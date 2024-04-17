package serialization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : sz
 * @Description :
 * @date : 2022-07-22 14:09
 **/
public class FastSerial {

    public static void main(String[] args) {


        JSONObject yingerJson= new JSONObject();
        yingerJson.put("fmyq","37周");
        yingerJson.put("fmfs","顺产");
        yingerJson.put("tclx","");
        List<JSONObject> list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("xb", "男");
        jsonObject.put("tz", "3.5kg");
        jsonObject.put("sc", "50cm");
        jsonObject.put("csjj","活产");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("sb", "女");
        jsonObject2.put("tz", "3.5kg");
        jsonObject2.put("sc", "50cm");
        jsonObject2.put("csjj","活产");
        list.add(jsonObject);
        list.add(jsonObject2);
        yingerJson.put("list",list);
        System.out.println(yingerJson.toString());
    }
}
