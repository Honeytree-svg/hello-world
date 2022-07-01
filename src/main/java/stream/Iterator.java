package stream;

import java.util.stream.Stream;

/**
 * @author : sz
 * @Description :
 * @date : 2022-06-23 10:32
 **/
public class Iterator {

    public static void main(String[] args) {

        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(2);
        limit.forEach(a->{
            System.out.println(a);
        });
    }
}
