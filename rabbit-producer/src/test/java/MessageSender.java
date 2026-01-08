import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
// 负责生产各式各样的消息到 RabbitMQ
public class MessageSender {

    static Connection conn;

    @BeforeAll
    public static void createConn() throws IOException, TimeoutException {
        // 先创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.135.77");
        factory.setPort(5672);
        factory.setUsername("rabbitmq");
        factory.setPassword("rabbitmq");
        factory.setVirtualHost("/mdmall");
        conn = factory.newConnection();
    }

    @Test
    public void t0() {
        log.info("建立rabbit连接：{}", conn);
    }

    // 简单模式消息
    @Test
    public void s1() throws IOException, TimeoutException {
        // 建立一个信道
        Channel channel = conn.createChannel();
        String queueName = "simple_queue";// 声明队列名称
        /**
         * 声明一个队列
         * 参数1：queueName 队列名称
         * 参数2：是否持久化消息
         * 参数3：是否时独占当前连接
         * 参数4：消费完毕后是否自动删除
         * 参数5：其他参数
         */
        channel.queueDeclare(queueName, true, false, true, null);
        String message = "你好！朱迪警官";
        /**
         * 发送一条消息
         * 参数1：交换机（普通模式可以省略，使用默认交换机）
         * 参数2：路由键（普通模式可写队列名称）
         * 参数3：其他额外的属性（可省略）
         * 参数4：待发送的消息内容（字节数组，需要将发送的数据进行编码，本例中选择utf-8编码集）
         */
        channel.basicPublish("", queueName, null, message.getBytes(StandardCharsets.UTF_8));
        log.info("消息已经成功投递到Rabbit！内容：{}", message);
        channel.close();
        conn.close();
    }

    // work 工作模式
    @Test
    public void s2() throws IOException, InterruptedException, TimeoutException {
        Channel channel = conn.createChannel();
        String queueName = "work_queue";
        channel.queueDeclare(queueName, true, false, true, null);
        // 使用循环来生产30条消息
        for (int i = 1; i <= 30; i++) {
            String message = "你好！狐尼克" + i;
            channel.basicPublish("", queueName, null, message.getBytes(StandardCharsets.UTF_8));
            log.info("已成功发送第{}条消息到RabbitMQ！内容：{}",i ,message);
            TimeUnit.MILLISECONDS.sleep(500);// 每隔半秒钟发下一条消息
        }
        channel.close();
        conn.close();
    }

    // 发布订阅 模式
    @Test
    public void s3() throws IOException, TimeoutException {
        Channel channel = conn.createChannel();
        String exchange = "fanout_exchange";// 定义一个交换机的名称（扇形交换机）
        // 声明两个队列名称
        String queue1 = "fanout_queue1";
        String queue2 = "fanout_queue2";
        /**
         * 声明交换机
         * 参数1：交换机的名称
         * 参数2：交换机的类型（本例选择扇形交换机）
         * 参数3：是否对消息进行持久化
         * 参数4：是否自动删除消息
         * 参数5：其他额外参数
         */
        channel.exchangeDeclare(exchange, BuiltinExchangeType.FANOUT, true, true, null);
        // 声明两个队列
        channel.queueDeclare(queue1, true, false, false, null);
        channel.queueDeclare(queue2, true, false, false, null);
        /**
         * 绑定交换机和队列
         * 参数1：队列名称
         * 参数2：交换机
         * 参数3：交换机和队列绑定的路由键（空白表示消息会同时发送给每一个绑定的队列）
         * 参数4：其他额外参数
         */
        channel.queueBind(queue1, exchange, "", null);
        channel.queueBind(queue2, exchange, "", null);
        String message = "你好，尊贵的VIP用户~贵宾通道已开启，随时可以使用";
        channel.basicPublish(exchange, "", null, message.getBytes(StandardCharsets.UTF_8));
        channel.close();
        conn.close();
    }

    // 路由模式
    @Test
    public void s4() throws IOException, TimeoutException {
        Channel channel = conn.createChannel();
        String exchange = "direct_exchange";// 智联交换机
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT, true, false, null);
        String queue1 = "direct_queue1";
        String queue2 = "direct_queue2";
        // 声明两个队列，和交换机绑定的路由键分别设置为“sport”和“traffic”
        channel.queueBind(queue1, exchange, "sport", null);
        channel.queueBind(queue2, exchange, "traffic", null);
        channel.queueBind(queue2, exchange, "study", null);
        // 发送消息的同时设置消息的路由键
        channel.basicPublish(exchange, "sport", null, "两只老虎跑得快，跑得快！".getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(exchange, "traffic", null, "小火车的轮子转呀转！".getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(exchange, "study", null, "小呀么小二郎，背个书包上学堂！".getBytes(StandardCharsets.UTF_8));
        log.info("消息已投递到队列！");
        channel.close();
        conn.close();
    }

    // 主题 模式
    /**
     * 诗词的绑定键 朝代、作者、主题
     * 举例 唐 李白 友情
     * 绑定键：*.*.friend
     */
    @Test
    public void s5() throws IOException, InterruptedException, TimeoutException {
        Channel channel = conn.createChannel();
        String exchange = "topic_exchange";// 主题交换机名称
        channel.exchangeDeclare(exchange, BuiltinExchangeType.TOPIC, true, false, null);
        String queue1 = "topic_queue1";
        String queue2 = "topic_queue2";
        channel.queueDeclare(queue1, true, false, false, null);
        channel.queueDeclare(queue2, true, false, false, null);
        // 第一个队列和交换机绑定：描绘友情的诗及李白的诗词
        channel.queueBind(queue1, exchange, "*.*.friend");
        channel.queueBind(queue1, exchange, "*.libai.*");
        // 第二个队列和交换机绑定，描绘景色的诗词
        channel.queueBind(queue2, exchange, "#.view");
        String m1 = "日照香炉生紫烟，遥看瀑布挂前川";
        String m2 = "桃花潭水深千尺，不及汪伦赠我情";
        String m3 = "会当凌绝顶，一览众山小";
        String m4 = "莫愁前路无知己，天下谁人不识君";
        channel.basicPublish(exchange, "tang.libai.view", null, m1.getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(exchange, "tang.libai.friend", null, m2.getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(exchange, "tang.dufu.view", null, m3.getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(exchange, "tang.gaoshi.friend", null, m4.getBytes(StandardCharsets.UTF_8));
        log.info("消息已投递到队列！");
        channel.close();
        conn.close();
    }

}
