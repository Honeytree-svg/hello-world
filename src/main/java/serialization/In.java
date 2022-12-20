package serialization;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javafx.beans.binding.BooleanExpression;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * @author : sz
 * @Description :
 * @date : 2022-10-24 10:00
 **/
public class In {

    public static void main(String[] args) {

        Integer col = 7;
        cellPosition(col);
        System.out.println(col);
        byte[] encode = Base64.getEncoder().encode("zmm:123456".getBytes(StandardCharsets.UTF_8));
        for (byte b:
             encode) {

            System.out.print(b);
        }
        String s = new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
        System.out.println(s);
        System.out.println(Base64.getEncoder().encodeToString("zmm:123456".getBytes(StandardCharsets.UTF_8)));

        List<Customer> list = new ArrayList<>();
        list.add(null);
        if (CollectionUtil.isNotEmpty(list)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

    private static void cellPosition(Integer col) {
        col--;
    }
}
