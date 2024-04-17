package designpattern.bridge.myidea.shape;

import designpattern.bridge.myidea.Shape;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 22:20
 **/
public class Circle implements Shape {

    @Override
    public String shape() {

        return "circle";
    }
}
