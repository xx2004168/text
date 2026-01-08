import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
public class JedisDemo {
    static Jedis jedis;

    @BeforeAll// 在所有的测试方法执行前，先执行这个注解下的方法，他要求方法必须是静态的
    public static void init() {
        jedis = new Jedis("192.168.135.77", 6379);
    }

    @Test
    void t0() {
        String ret = jedis.ping("hello redis!");
        log.info("redis返回数据 {}", ret);
    }
    // 使用String类型
    @Test
    void t1() throws InterruptedException {
        jedis.set("info", "祝许鑫");
        jedis.append("info", "天天开心");
        jedis.expire("info", 3);
//        TimeUnit.SECONDS.sleep(5);// 5秒后info这个key过期，获取到的是null
        String info = jedis.get("info");
        log.info("获取到redis缓存的数据：{}", info);
    }

    // 使用list类型
    @Test
    void t2() {
        jedis.del("fruitList");// 先将key删除，然后重新push数据
        jedis.rpush("fruitList", "苹果", "柿子", "沙糖桔", "香蕉", "沙糖桔");
        jedis.lpush("fruitList", "葡萄", "火龙果");
        // 删除列表中指定个数的某个元素，并返回实际删除个数
        long n = jedis.lrem("fruitList", 2, "柿子");
        List<String> fruitList = jedis.lrange("fruitList", 0, -1);
        // 输出水果列表
        System.out.println(fruitList);
        log.info("fruitList中的元素个数：{}", jedis.llen("fruitList"));
    }

    // 使用set类型
    @Test
    void t3() {
        jedis.del("citySet");
        jedis.sadd("citySet", "harbin", "beijing", "hangzhou", "guangzhou", "shanghai", "harbin");
        log.info("集合citySet中的成员个数：{}", jedis.scard("citySet"));
        Set<String> members = jedis.smembers("citySet");
        // 打印输出成员
        members.forEach(System.out::println);
        // 判断集合中是否存在某个成员
        boolean exists = jedis.sismember("citySet", "changchun");
        log.info("集合citySet当中 {} changchun", exists ? "有": "没有");
    }

    // 使用ZSet类型
    @Test
    void t4() throws Exception {
        jedis.zadd("movieZSet", 9.5, "哪吒之魔童闹海");
        jedis.zadd("movieZSet", 8.5, "唐探1900");
        jedis.zadd("movieZSet", 8.0, "熊出没之重启未来");
        jedis.zadd("movieZSet", 7.0, "蛟龙行动");
        jedis.zadd("movieZSet", 4.5, "射雕之侠之大者");
        jedis.zadd("movieZSet", 1.0, "封神II");
        // 返回ZSet中全部成员, 按照score由高到低
        Set<String> movies = jedis.zrevrange("movieZSet", 0, -1);
        // 返回ZSet中全部成员, 按照score由低到高
//        Set<String> movies = jedis.zrange("movieZSet", 0, -1);
        movies.forEach(System.out::println);
        // Tuple元组，包含两个信息（Element和Score）
        Set<Tuple> tupleSet = jedis.zrangeWithScores("movieZSet", 0, -1);
        tupleSet.forEach(tuple -> {
            log.info("电影：{}，评分：{}", tuple.getElement(), tuple.getScore());
        });
    }

    // 使用hash类型
    @Test
    void t5() {
        jedis.hset("student1", "name", "哪吒");
        jedis.hset("student1", "teacher", "太乙真人");
        jedis.hset("student1", "weapon", "火尖枪、乾坤圈、风火轮");
        jedis.hset("student1", "home", "陈塘关");
        // 获取某个hash表的某个field的value
        String val = jedis.hget("student1", "name");
        log.info(val);
        jedis.hgetAll("student1").forEach((k, v) -> {
            log.info("Field:{}, Value: {}", k, v);
        });
    }

    // Redis的消息订阅和发布
    @Test
    void t6() throws InterruptedException {
        // 当前线程订阅了三个redis频道（主题）
        jedis.subscribe(new JedisPubSub() {
            @Override
            // 当其他线程在我订阅的channel下发布消息后，我会被唤醒，执行onMessage 方法
            public void onMessage(String channel, String message) {
                log.info("接收到 {} 批到发布的消息，内容如下：{}", channel, message);
            }
        }, "Traffic", "Sport", "Music");
        log.info("当前线程进入睡眠状态，等待消息到来~");
        TimeUnit.MINUTES.sleep(2);// 睡眠两分钟，保证当前线程是存活
    }

    @Test
    void t7() {
        jedis.publish("Sport", "韩国短道速滑队又玩不起~");
        jedis.publish("Music", "周杰伦发布最新单曲《稻香》");
    }
}
