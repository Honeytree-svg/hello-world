package designpattern.factory;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:22
 **/
public class CalculateMultiply extends Calculate{

    public CalculateMultiply(double numA, double numB){
        super();
        this.numA=numA;
        this.numB=numB;
    }

    public CalculateMultiply() {
    }

    @Override
    public double cal() {
        return numA*numB;
    }
}
