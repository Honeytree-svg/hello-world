package designpattern.factory.factorymethod;

import designpattern.factory.Calculate;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:23
 **/
public abstract class CalculateFactory {
    public abstract Calculate getCalculate();
}
