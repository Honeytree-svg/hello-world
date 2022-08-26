package designpattern.bridge.myidea;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-01 23:08
 **/
public class AuthorPaint extends Painting{
    private String author;


    public AuthorPaint() {
    }

    public AuthorPaint(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    void print() {
        System.out.println(author + " draw a " + scale.scale() + " " + color.color() + " " +shape.shape());
    }
}
