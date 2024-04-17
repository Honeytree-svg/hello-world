package tree.menu;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : sz
 * @Description :
 * @date : 2022-09-21 13:02
 **/
public class T {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String s = "https://devtestminio.wiseheartdoctor.cn/dev/fj/公卫路由跳转.png";
        String[] split = s.split("fj/");
        String mc = split[split.length - 1];
        //System.out.println(-1l);

        byte a = 0;
        System.out.println(~a);

        String aaa = URLEncoder.encode("AAA", "UTF-8");
    }
}
