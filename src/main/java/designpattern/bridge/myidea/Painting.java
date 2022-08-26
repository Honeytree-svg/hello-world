package designpattern.bridge.myidea;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 23:04
 **/
public abstract class Painting {

    protected Color color;
    protected Scale scale;
    protected Shape shape;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    abstract void print();
}
