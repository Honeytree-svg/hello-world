package xstream.msg;

import javax.xml.bind.annotation.XmlAttribute;

public class H {

    private String M;

    public String getM() {
        return M;
    }

    @XmlAttribute(name = "M")
    public void setM(String m) {
        M = m;
    }

    @Override
    public String toString() {
        return "H{" +
                "M='" + M + '\'' +
                '}';
    }
}
