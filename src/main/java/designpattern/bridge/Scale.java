package designpattern.bridge;

public abstract class Scale {
    protected Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }
    protected abstract void scale();
}
