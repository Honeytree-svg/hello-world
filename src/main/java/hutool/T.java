package hutool;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : sz
 * @Description :
 * @date : 2022-12-14 17:14
 **/
public class T {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> list1 = Arrays.asList("2022-12-12", "2022-11-22");
        List<String> list2 = Arrays.asList("2022-11-21", "2022-11-02");
//        list.addAll(list1);
//        list.addAll(list2);
//        list.sort(Comparator.comparing(String::toString));
//        System.out.println(list);
    }
}
