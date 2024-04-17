package designpattern.bridge.scale;

import designpattern.bridge.Scale;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 22:19
 **/
public class Small extends Scale {

    @Override
    protected void scale() {
        shape.draw("small");
    }
}
