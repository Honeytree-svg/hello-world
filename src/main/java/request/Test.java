package request;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : sz
 * @Description :
 * @date : 2022-11-17 11:14
 **/
public class Test {

    public static void main(String[] args) {

        JSONObject body = new JSONObject();
        //body.put("sjly","CMS");
        //body.put("zfbz","2");
        String data = HttpRequest.post("https://dev.wiseheartdoctor.cn/api/cms/getCommonCodeInfo")
                .header("Backend", "CMS")
                .body(body.toJSONString())
                .execute().body();

        JSONObject jsonObject = JSONObject.parseObject(data);
        if (!jsonObject.containsKey("code") || !"200".equals(jsonObject.get("code").toString()))
            return ;

        List<XtGydm> result = JSONArray.parseArray(jsonObject.get("result").toString(), XtGydm.class);
        System.out.println(result);
    }
}
