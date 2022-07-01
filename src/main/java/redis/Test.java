package redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

public class Test {

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("117.50.182.75");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
        jedis.set("test","1");

        JSONObject json = new JSONObject();
        json.put("name","111");

        JSONObject amount = new JSONObject();
        amount.put("price","20");
        amount.put("totalAmount","20");

        json.put("amount",amount);
    }
}
