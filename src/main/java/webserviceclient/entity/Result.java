package webserviceclient.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "class_KD_INTERFACE_V3_result")
public class Result {


    private String resultCode;

    private String resultMessage;

    private String data;

    public String getResultCode() {
        return resultCode;
    }
    @XmlElement(name = "resultCode")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }
    @XmlElement(name = "resultMessage")
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getData() {
        return data;
    }
    @XmlElement(name = "data")
    public void setData(String data) {
        this.data = data;
    }
}
