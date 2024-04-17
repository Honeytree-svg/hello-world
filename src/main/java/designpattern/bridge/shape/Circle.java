package designpattern.bridge.shape;

import designpattern.bridge.Shape;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 22:20
 **/
public class Circle extends Shape {

    public void draw(String scale) {
        color.bepaint(scale+"正方形");
    }
}
