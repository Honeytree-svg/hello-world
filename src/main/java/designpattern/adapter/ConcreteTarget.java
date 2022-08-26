package designpattern.adapter;

import designpattern.adapter.Target;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 14:59
 **/
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
