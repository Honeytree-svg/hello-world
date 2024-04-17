package stream.groupby;

import stream.Model;
import stream.Vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author : sz
 * @Description :
 * @date : 2022-07-01 11:40
 **/
public class GroupBy {

    public static void main(String[] args) {

        List<Model> list = new ArrayList<>();
        list.add(new Model("001","aaa","1"));
        list.add(new Model("001","aaa","2"));
        list.add(new Model("001","bbb","3"));
        list.add(new Model("001","bbb","4"));
        list.add(new Model("001","bbb","5"));


        ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, Model>>> collect = list.stream().collect(Collectors.groupingBy(Model::getKey1, ConcurrentHashMap::new, Collectors.groupingBy(Model::getKey2, ConcurrentHashMap::new, Collectors.toMap(Model::getKey3, t -> t, (t1, t2) -> t1, ConcurrentHashMap::new))));

        System.out.println(collect);
    }
}
