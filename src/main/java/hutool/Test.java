package hutool;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("page","1");
        paramMap.put("size","999");
        paramMap.put("idCard","220102199003074655");

        String sync = OkHttpUtils.builder().url("https://dev.wiseheartdoctor.cn/api/selectSystemParameter")
                .addHeader("x-appType", "IMS")
                .addHeader("x-originCode", "3306240011")
                .addHeader("Authorization", "")
                .addParam(new HashMap<String,String>(){{put("code","JM_WZCJMBGTSDX");}})
                .get().sync();

        Object result = JSONObject.parseObject(sync).get("result");
        Object list = JSONObject.parseObject(result.toString()).get("list");
        JSONArray objects = JSONArray.parseArray(list.toString());
        Object o = objects.get(0);
        JSONObject jsonObject = JSONObject.parseObject(o.toString());
        Object value = jsonObject.get("value");
        System.out.println(value);
    }
}
