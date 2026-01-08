import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class MessageReceiver {

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
    public void r1() throws IOException, TimeoutException, InterruptedException {
        Channel channel = conn.createChannel();// 建立信道
        String queueName = "simple_queue";// 声明队列名称
        // 声明队列
        channel.queueDeclare(queueName, true, false,true, null);
        // 创建一个默认的消费者实例，然后和前面声明的信道建立联系
        Consumer consumer = new DefaultConsumer(channel) {
            // 当接收到新消息时会自动执行这个方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("1号消费者（兔朱迪）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));
            }
        };
        /**
         * 设置消费者监听指定的队列
         * 参数1：队列的名称
         * 参数2：是否自动确认：接收到消息之后自动向消息队列回复一个 ack 确认通知
         * 参数3：消费者实例
         */
        channel.basicConsume(queueName, true, consumer);
        TimeUnit.MINUTES.sleep(2);// 当前线程睡眠两分钟，可以不停的接收消息
        channel.close();
        conn.close();
    }

    // 多个消费者负载均衡的消费消息（工作模式）
    @Test
    public void r2() throws IOException, TimeoutException, InterruptedException {
        Channel channel = conn.createChannel();// 建立信道
        String queueName = "work_queue";// 声明队列名称
        channel.queueDeclare(queueName, true, false,true, null);
        Consumer c1 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("2号消费者（牛局长）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));

            }
        };
        log.info("2号消费者（牛局长）准备完毕！");
        channel.basicConsume(queueName, true, c1);

        Consumer c2 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("3号消费者（狼警官）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));

            }
        };
        log.info("3号消费者（狼警官）准备完毕！");
        channel.basicConsume(queueName, true, c2);

        Consumer c3 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("3号消费者（豹警官）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));

            }
        };
        log.info("3号消费者（豹警官）准备完毕！");
        channel.basicConsume(queueName, true, c3);
        // 所有消费者准备就绪后，让线程睡眠两分钟，等待消息到来
        TimeUnit.MINUTES.sleep(2);
        channel.close();
        conn.close();
    }

    // 扇形交换机 发布/订阅模式小的消息消费
    @Test
    public void r3() throws IOException, InterruptedException, TimeoutException {
        Channel channel = conn.createChannel();
        String queue1 = "fanout_queue1";
        String queue2 = "fanout_queue2";
        channel.queueDeclare(queue1, true, false, false, null);
        channel.queueDeclare(queue2, true, false, false, null);
        DefaultConsumer c5 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("5号消费者（狮子市长）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));
            }
        };
        channel.basicConsume(queue1, c5);// 5号消费者订阅队列1
        DefaultConsumer c6 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("6号消费者（羊副市长）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));
            }
        };
        channel.basicConsume(queue2, c6);// 6号消费者订阅队列2
        log.info("5号消费者（狮子市长）准备完毕！他订阅了1号队列");
        log.info("6号消费者（羊副市长）准备完毕！他订阅了2号队列");
        TimeUnit.MINUTES.sleep(2);
        channel.close();
        conn.close();

    }

    // 路由模式下的消息消费
    @Test
    public void r4() throws IOException, InterruptedException, TimeoutException {
        Channel channel = conn.createChannel();
        String queue1 = "direct_queue1";
        String queue2 = "direct_queue2";
        channel.queueDeclare(queue1, true, false, false, null);
        channel.queueDeclare(queue2, true, false, false, null);
        DefaultConsumer c5 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("5号消费者（狮子市长）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));
            }
        };
        channel.basicConsume(queue1, c5);// 5号消费者订阅队列1
        DefaultConsumer c6 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("6号消费者（羊副市长）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));
            }
        };
        channel.basicConsume(queue2, c6);// 6号消费者订阅队列2
        log.info("5号消费者（狮子市长）准备完毕！他订阅了1号队列");
        log.info("6号消费者（羊副市长）准备完毕！他订阅了2号队列");
        TimeUnit.MINUTES.sleep(2);
        channel.close();
        conn.close();

    }

    // 路由模式下的消息消费
    @Test
    public void r5() throws IOException, InterruptedException, TimeoutException {
        Channel channel = conn.createChannel();
        String queue1 = "topic_queue1";
        String queue2 = "topic_queue2";
        channel.queueDeclare(queue1, true, false, false, null);
        channel.queueDeclare(queue2, true, false, false, null);
        DefaultConsumer c5 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("5号消费者（狮子市长）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));
            }
        };
        channel.basicConsume(queue1, c5);// 5号消费者订阅队列1
        DefaultConsumer c6 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("6号消费者（羊副市长）接收到新消息：{}", new String(body, StandardCharsets.UTF_8));
            }
        };
        channel.basicConsume(queue2, c6);// 6号消费者订阅队列2
        log.info("5号消费者（狮子市长）准备完毕！他订阅了1号队列");
        log.info("6号消费者（羊副市长）准备完毕！他订阅了2号队列");
        TimeUnit.MINUTES.sleep(2);
        channel.close();
        conn.close();

    }



}
