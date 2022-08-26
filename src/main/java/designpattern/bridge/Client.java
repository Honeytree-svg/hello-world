package designpattern.bridge;

import designpattern.bridge.color.White;
import designpattern.bridge.scale.Big;
import designpattern.bridge.shape.Circle;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 22:23
 **/
public class Client {
    public static void main(String[] args) {

        Shape circle = new Circle();
        circle.setColor(new White());
        Scale big = new Big();
        big.setShape(circle);
        big.scale();
    }
}
