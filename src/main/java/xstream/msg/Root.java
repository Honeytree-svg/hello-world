package main.java.xstream.msg;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Root")
public class Root {

    private String version;
    private String User;
    private String PWD;
    private String UserType;
    private String CorpCode;

    private SMS SMS;

    public String getVersion() {
        return version;
    }

    @XmlAttribute(name = "version")
    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser() {
        return User;
    }

    @XmlAttribute(name = "User")
    public void setUser(String user) {
        User = user;
    }

    public String getPWD() {
        return PWD;
    }

    @XmlAttribute(name = "PWD")
    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public String getUserType() {
        return UserType;
    }

    @XmlAttribute(name = "UserType")
    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getCorpCode() {
        return CorpCode;
    }

    @XmlAttribute(name = "CorpCode")
    public void setCorpCode(String corpCode) {
        CorpCode = corpCode;
    }

    public main.java.xstream.msg.SMS getSMS() {
        return SMS;
    }

    @XmlElement(name = "SMS")
    public void setSMS(main.java.xstream.msg.SMS SMS) {
        this.SMS = SMS;
    }

    @Override
    public String toString() {
        return "Root{" +
                "version='" + version + '\'' +
                ", User='" + User + '\'' +
                ", PWD='" + PWD + '\'' +
                ", UserType='" + UserType + '\'' +
                ", CorpCode='" + CorpCode + '\'' +
                ", SMS=" + SMS +
                '}';
    }
}
