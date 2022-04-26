package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ListToString {

    public static void main(String[] args) {

//        List<String> list = Arrays.asList("111","222","333");
//        //list.toString();
//
//        System.out.println(list.toString());
//
//        Supplier<Double> random = Math::random;
//        random.get();

        List<String> wordList = Arrays.asList("Java 8", "Lambdas", "In", "Action");

        List<String> strList = wordList.stream()
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
