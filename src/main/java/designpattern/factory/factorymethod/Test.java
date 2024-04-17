package designpattern.factory.factorymethod;

import designpattern.factory.Calculate;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:48
 **/
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        CalculateFactory calculateAddFactory = new CalculateAddFactory();
        CalculateFactory calculateMultiFactory = new CalculateMultiplyFactory();
        Calculate calculateAdd = calculateAddFactory.getCalculate();
        calculateAdd.setNumA(1);
        calculateAdd.setNumB(2);
        System.out.printf("计算结果为：%f\n",calculateAdd.cal());
        Calculate calculateMultiply = calculateMultiFactory.getCalculate();
        calculateMultiply.setNumA(1);
        calculateMultiply.setNumB(2);
        System.out.printf("计算结果为：%f\n",calculateMultiply.cal());

        // 通过反射机制获取工厂类
        Class c = Class.forName(CalculateAddFactory.class.getName());
        CalculateFactory factory = (CalculateFactory) c.newInstance();
        Calculate calculateSample = factory.getCalculate();
        calculateSample.setNumB(2);
        calculateSample.setNumA(3);
        System.out.printf("计算结果为：%f\n",calculateSample.cal());
    }
}
