package designpattern.factory;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 15:21
 **/
public abstract class Calculate {
    double numA;
    double numB;

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }

    public Calculate(){
    }
    public Calculate(double numA,double numB){
        this.numA = numA;
        this.numB = numB;
    }
    public abstract double cal();

}