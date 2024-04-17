package hutool;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : sz
 * @Description :
 * @date : 2022-06-24 11:21
 **/
public class HttpTest {

    public static void main(String[] args) {

        List<String> idcards = new ArrayList<>();
        idcards.add("110101199003078195");
        idcards.add("330624199811156262");

        Map<String, Object> param = new HashMap<>();
        param.put("sfzh",idcards);
        param.put("zhlx","1");

        String s = HttpUtil.toParams(param);


        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("page","1");
        jsonObject2.put("size","999");
        jsonObject2.put("idCard","110101199003071612");

        String body1 = HttpRequest.get("https://dev.wiseheartdoctor.cn/api/selectSystemParameter?code=JM_WZCJMBGTSDX")
                .header("x-originCode","3306240011")
                .execute().body();

        System.out.println(body1);


    }
}
