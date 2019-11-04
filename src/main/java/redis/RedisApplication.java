package redis;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import java.util.Set;

@SpringBootApplication
public class RedisApplication extends JedisPubSub {

    /**
     * 取得订阅的消息后的处理
      */
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("频道是：【" + channel + "】----" +
                "发布的消息是：【" + message + "】");

    }

    /**
     * 初始化订阅时候的处理
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        // System.out.println(channel + "=" + subscribedChannels);
    }


    /**
     * 取消订阅时候的处理
     */
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        // System.out.println(channel + "=" + subscribedChannels);
    }


    /**
     *初始化按表达式的方式订阅时候的处理
     */
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        // System.out.println(pattern + "=" + subscribedChannels);
    }


    /**
     *取消按表达式的方式订阅时候的处理
     */
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        // System.out.println(pattern + "=" + subscribedChannels);
    }


    /**
     *取得按表达式的方式订阅的消息后的处理
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        //业务逻辑处理....
        System.out.println(pattern + "=" + channel + "=" + message);
    }

    public static void main(String[] args) {


        Jedis jedis = new Jedis("127.0.0.1", 6379);


        RedisApplication redisApplication = new RedisApplication();
        //订阅channel
        jedis.subscribe(redisApplication, "channel");


       /* System.out.println("测试一下：PING！" + jedis.ping());

        System.out.println("是否存在:" + jedis.exists("00"));
        //过期时间
        System.out.println("过期时间（-1永不过期，-2不存在）：" + jedis.ttl("key0"));
        System.out.println("get一个key=key0的value:" + jedis.get("key0"));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> keys = jedis.keys("*");
        for (String js : keys) {
            System.out.println("这是一个key名：" + js);
        }

*/
        // SpringApplication.run(RedisApplication.class, args);
    }

}
