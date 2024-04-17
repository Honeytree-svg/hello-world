package designpattern.factory;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:22
 **/
public class CalculateAdd extends Calculate{

    public CalculateAdd(double numA,double numB){
        super();
        this.numA=numA;
        this.numB = numB;
    }

    public CalculateAdd() {
    }

    @Override
    public double cal() {
        return numA+numB;
    }
}