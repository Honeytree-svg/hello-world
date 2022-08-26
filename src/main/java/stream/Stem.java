package stream;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-22 16:55
 **/
public class Stem {

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("xb", "男");
        jsonObject.put("tz", "3.5kg");
        jsonObject.put("sc", "50cm");
        jsonObject.put("csjj","活产");

        List<String> keys = jsonObject.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder action = new StringBuilder("method=test" + "?");
        keys.forEach(key ->{
            action.append(key +"="+jsonObject.get(key).toString()+"&");
        });

        System.out.println(action.toString());
    }
}
