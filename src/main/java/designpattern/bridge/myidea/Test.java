package designpattern.bridge.myidea;

import designpattern.bridge.myidea.color.White;
import designpattern.bridge.myidea.scale.Big;
import designpattern.bridge.myidea.shape.Circle;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 23:01
 **/
public class Test {

    public static void main(String[] args) {
        Painting authorPaint = new AuthorPaint("sz");
        authorPaint.setColor(new White());
        authorPaint.setScale(new Big());
        authorPaint.setShape(new Circle());
        authorPaint.print();
    }
}
