package main.java.xstream.msg;

import javax.xml.bind.annotation.XmlElement;

public class SMS {

    private String M;
    private H H;

    private String Return;

    public String getM() {
        return M;
    }

    @XmlElement(name = "M")
    public void setM(String m) {
        M = m;
    }

    public main.java.xstream.msg.H getH() {
        return H;
    }

    @XmlElement(name = "H")
    public void setH(main.java.xstream.msg.H h) {
        H = h;
    }

    public String getReturn() {
        return Return;
    }

    @XmlElement(name = "Return")
    public void setReturn(String aReturn) {
        Return = aReturn;
    }

    @Override
    public String toString() {
        return "SMS{" +
                "M='" + M + '\'' +
                ", H=" + H +
                ", Return='" + Return + '\'' +
                '}';
    }
}
