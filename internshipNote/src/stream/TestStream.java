package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String args[]) {
        
        Random random = new Random();
        List<Model> list = new ArrayList<Model>();
        for (int i = 0; i < 5; i++) {
            Model model = new Model();

            model.setPartsId(String.valueOf(random.nextInt(10)));
            model.setValue(String.valueOf(i));
            list.add(model);
        }
        list.forEach(System.out::println);
        list.sort((Model o1,Model o2)->o1.getPartsId().compareTo(o2.getPartsId()));
        list.forEach(System.out::println);
        
        Map<String, List<Model>> map;
        //map = list.stream().collect(Collectors.toMap(Model::getPartsId, Function.identity(),(key1,key2)->key2));
        //map.forEach((String key,Model value)->{ System.out.println(key + ":" + value.toString());});
        map = list.stream().collect(Collectors.toMap(Model::getPartsId, 
                value -> new ArrayList(Arrays.asList(value)),
                (List<Model> oldList,List<Model> newList)->{
                    newList.forEach(item -> oldList.add(item));
                    return oldList;
                }));
        
        map.forEach((String key, List<Model> value) -> {
            System.out.println(key + ":" + value.toString());
        });
    }
}
