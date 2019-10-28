package redis;

import redis.clients.jedis.JedisPubSub;

public class Listener  extends JedisPubSub {

    @Override

    public void onMessage(String channel, String message) {
        System.out.println(channel + "=" + message);
    }






}
