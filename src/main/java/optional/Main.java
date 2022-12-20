package optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : sz
 * @Description :
 * @date : 2022-10-08 13:47
 **/
public class Main {

    public static void main(String[] args) {

        Obb o = new Obb();
        o.setList(Arrays.asList("1","2","3"));
        List<Obb> list = new ArrayList<>();
        list.add(o);
        list.stream().map(m -> m.getList().toArray()).forEach(System.out::println);
        list.stream().flatMap(c -> Stream.of(c.getList().toArray())).forEach(System.out::println);

    }
}
