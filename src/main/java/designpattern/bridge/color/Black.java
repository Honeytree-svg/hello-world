package designpattern.bridge.color;

import designpattern.bridge.Color;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 22:15
 **/
public class Black implements Color {

    private String color = "black";

    @Override
    public void bepaint(String shape) {
        System.out.println(color + " " + shape);
    }
}
