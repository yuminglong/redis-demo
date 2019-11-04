package redis;

import redis.clients.jedis.Jedis;

public class RedisPublisher {
    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //发布
        jedis.publish("channel","welcome to the 搞么的啊搜嘎");
        jedis.close();

    }
}
