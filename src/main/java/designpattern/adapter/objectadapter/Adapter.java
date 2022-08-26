package designpattern.adapter.objectadapter;

import designpattern.adapter.Adaptee;
import designpattern.adapter.Target;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:03
 **/
public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    public void request() {
        adaptee.adapterRequest();
    }
}
