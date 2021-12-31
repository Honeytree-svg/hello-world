package stream;

public class Model {

    String partsId;
    String value;
    public String getPartsId() {
        return partsId;
    }
    public void setPartsId(String partsId) {
        this.partsId = partsId;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Model [partsId=" + partsId + ", value=" + value + "]";
    }

}
