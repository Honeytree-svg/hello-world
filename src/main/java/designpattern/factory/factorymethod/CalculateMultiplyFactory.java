package designpattern.factory.factorymethod;

import designpattern.factory.Calculate;
import designpattern.factory.CalculateAdd;
import designpattern.factory.CalculateMultiply;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:46
 **/
public class CalculateMultiplyFactory extends CalculateFactory{
    @Override
    public Calculate getCalculate() {
        return new CalculateMultiply();
    }
}
