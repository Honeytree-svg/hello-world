package tree.menu;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : sz
 * @Description :
 * @date : 2022-09-16 15:57
 **/
@Data
@Accessors(chain = true)
public class Menu {

    private String id;

    private String parentId;

    private String name;

    private String gllx;

    private String url;

    private String bgid;

    // 0 无修改；1 修改
    private String isModifyied;

    private List<Menu> children;
}
