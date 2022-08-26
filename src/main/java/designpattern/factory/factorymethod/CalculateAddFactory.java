package designpattern.factory.factorymethod;

import designpattern.factory.Calculate;
import designpattern.factory.CalculateAdd;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:46
 **/
public class CalculateAddFactory extends CalculateFactory{
    @Override
    public Calculate getCalculate() {
        return new CalculateAdd();
    }
}
