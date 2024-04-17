package net;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author : sz
 * @Description :
 * @date : 2022-10-21 15:00
 **/
public class Main {

    public static void main(String[] args) {


        String body = HttpRequest.post("https://test.wiseheartdoctor.cn/api/bos/drjyptqyjlmx")
                .header("x-originCode","3306240101")
                .body("{\"eq\":{\"date\":\"2022-10-18\"},\"page\":1,\"size\":15,\"sort\":{},\"count\":true}")
                .execute()
                .body();

        System.out.println(body);
        JSONObject jsonObject = JSONObject.parseObject(body);
        if (200 != Integer.parseInt(jsonObject.get("code").toString()))
            return;

        JSONObject result = JSONObject.parseObject(jsonObject.get("result").toString());
        if (!result.containsKey("data"))
            return;
        List<Map> data = JSONArray.parseArray(result.get("data").toString(), Map.class);
        data.stream().forEach(System.out::println);
    }
}
