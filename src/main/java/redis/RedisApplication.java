package redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

import java.util.Set;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println("测试一下：PING！" + jedis.ping());

        System.out.println(jedis.exists("00"));
        System.out.println(jedis.ttl("key0"));
        System.out.println(jedis.get("key0"));
        Set<String> keys = jedis.keys("*");
        for (String js: keys) {
            System.out.println(js);
        }


        // SpringApplication.run(RedisApplication.class, args);
    }

}
