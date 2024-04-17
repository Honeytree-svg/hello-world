package stream;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : sz
 * @Description :
 * @date : 2022-12-09 16:34
 **/
public class Max {
    public static void main(String[] args) {

        int i = "2022-12-10".compareTo("2022-11-10");
        System.out.println(i);
        DateTime endOfDay = DateUtil.endOfDay(DateUtil.date());
        System.out.println(endOfDay);


        A a = new A("2022-10-11");
        A a1 = new A("2022-12-12");
        A a2 = new A("2022-11-12");
        List<A> list = Arrays.asList(a,a1,a2);
        A a3 = list.stream().sorted(Comparator.comparing(A::getDate).reversed()).findFirst().get();
        System.out.println(a3.getDate());
    }

    @Data
    @AllArgsConstructor
    static class A{

        private String date;
    }
}
