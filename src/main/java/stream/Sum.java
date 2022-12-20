package stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : sz
 * @Description :
 * @date : 2022-09-07 10:21
 **/
public class Sum {

    public static void main(String[] args) {
        List<GUshi> gUshis = new ArrayList<>();
        gUshis.add(new GUshi("123",12));
        gUshis.add(new GUshi("222",122));
        gUshis.add(new GUshi());
        IntSummaryStatistics collect = gUshis.stream().collect(Collectors.summarizingInt(GUshi::getAge));
        System.out.println(collect.getSum());

        System.out.println("pp015_".substring(2,5));
    }
}
