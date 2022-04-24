package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ListToString {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("111","222","333");
        //list.toString();

        System.out.println(list.toString());

        Supplier<Double> random = Math::random;
        random.get();
    }
}
