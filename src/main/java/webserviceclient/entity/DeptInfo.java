package webserviceclient.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "req")
public class DeptInfo {

    //@XmlElement(name = "hospitalId")
    private String hospitalId;
    //@XmlElement(name = "hospitalId")
    private String deptId;
   // @XmlElement(name = "deptType")
    private String deptType;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }
}
