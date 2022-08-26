package designpattern.adapter.classadapter;

import designpattern.adapter.ConcreteTarget;
import designpattern.adapter.Target;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:01
 **/
public class Test {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
