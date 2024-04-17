package designpattern.bridge.color;

import designpattern.bridge.Color;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 22:14
 **/
public class White implements Color {

    private String color = "white";

    @Override
    public void bepaint(String shape) {
        System.out.println(color + " " + shape);
    }
}
