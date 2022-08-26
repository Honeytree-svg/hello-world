package wuliao;

import wuliao.entity.Consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author : sz
 * @Description :
 * @date : 2022-07-08 16:43
 **/
public class Yazhouti {

    public static void main(String[] args) {

    }


    static void maxcost(List<Consumer> consumer){

        HashMap<Integer, Float> pidMap = new HashMap<>();
        Map<Integer, List<Consumer>> collect = consumer.stream().collect(Collectors.groupingBy(Consumer::getPid));
        collect.forEach((pid,items)->{
            AtomicReference<Float> cost = new AtomicReference<>(Float.valueOf(0));
            items.stream().forEach(item->{

                cost.updateAndGet(v -> v + item.getCost());
            });
            pidMap.put(pid,cost.get());
        });
        AtomicInteger pid = new AtomicInteger(0x7FFFFFFF);
        float cost = 0;
        pidMap.forEach((k,v)->{

            if (v>cost)
                pid.set(k);
        });

        System.out.println(pid);
    }
}
