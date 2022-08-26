package designpattern.bridge.myidea.scale;

import designpattern.bridge.myidea.Scale;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 22:19
 **/
public class Big implements Scale {

    @Override
    public String scale() {
        return "big";
    }
}
