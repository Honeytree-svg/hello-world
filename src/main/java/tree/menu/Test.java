package tree.menu;

import cn.hutool.core.util.StrUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : sz
 * @Description :
 * @date : 2022-09-16 16:03
 **/
public class Test {

    public static void main(String[] args) {

        Queue<Menu> menus = new LinkedBlockingQueue<>();
        List<Menu> list = new ArrayList<>();
        init(list);
        for (Menu menu : list) {
            menus.add(menu);
        }
        while (!menus.isEmpty()){

            Menu poll = menus.poll();

            if (!CollectionUtils.isEmpty(poll.getChildren())){
                poll.getChildren().forEach(item -> menus.add(item));
            }

            if (StrUtil.isBlank(poll.getId())){
                System.out.println("儿子新增：" + poll.getParentId());
                // 把id传给子级
                if (!CollectionUtils.isEmpty(poll.getChildren())){
                    poll.getChildren().forEach(item -> item.setParentId("3"));
                }
            }else if (StrUtil.isNotBlank(poll.getId()) && poll.getIsModifyied().equals("1")){
                System.out.println(poll.getId()+":更新");
            }

        }

    }

    private static void init(List<Menu> list) {

        Menu main1 = new Menu().setId("1").setParentId("-1").setIsModifyied("1").setChildren(new ArrayList<>());
        Menu main2 = new Menu().setId("2").setParentId("-1").setIsModifyied("1").setChildren(new ArrayList<>());
        Menu main3 = new Menu().setId("").setParentId("-1").setIsModifyied("0").setChildren(new ArrayList<>());

        Menu sub11 = new Menu().setId("11").setParentId("1").setIsModifyied("1").setChildren(new ArrayList<>());
        Menu sub12 = new Menu().setId("").setParentId("1").setIsModifyied("0").setChildren(new ArrayList<>());

        Menu sub21 = new Menu().setId("21").setParentId("2").setIsModifyied("1").setChildren(new ArrayList<>());
        Menu sub22 = new Menu().setId("22").setParentId("2").setIsModifyied("1").setChildren(new ArrayList<>());

        Menu sub31 = new Menu().setId("").setParentId("").setIsModifyied("0").setChildren(new ArrayList<>());
        Menu sub32 = new Menu().setId("").setParentId("").setIsModifyied("0").setChildren(new ArrayList<>());

        main1.getChildren().add(sub11);
        main1.getChildren().add(sub12);

        main2.getChildren().add(sub21);
        main2.getChildren().add(sub22);

        main3.getChildren().add(sub31);
        main3.getChildren().add(sub32);

        list.add(main1);
        list.add(main2);
        list.add(main3);
    }
}
