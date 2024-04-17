package designpattern.factory.simplefactory;

import designpattern.factory.Calculate;
import designpattern.factory.CalculateMultiply;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:24
 **/
public class Test {
    public static void main(String[] args) {
        CalculateFactory calculateFactory = new CalculateFactory();
        Calculate calculate = calculateFactory.getCalculate(CalculateMultiply.class);
        if(calculate == null){
            System.out.printf("没能创建成功\n");
        }else{
            calculate.setNumA(1);
            calculate.setNumB(3);
            System.out.printf("计算结果为：%f\n",calculate.cal());
        }
    }
}
