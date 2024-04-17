package designpattern.factory.simplefactory;

import designpattern.factory.Calculate;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:23
 **/
public class CalculateFactory {

    public Calculate getCalculate(Class c){
        Calculate calculate = null;

        try{
            Class <?> cls = Class.forName(c.getName()) ;
            calculate = (Calculate) cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return calculate;
    }
}
