package designpattern.adapter.classadapter;

import designpattern.adapter.Adaptee;
import designpattern.adapter.Target;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:00
 **/
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapterRequest();
    }
}
