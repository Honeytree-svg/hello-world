package webserviceclient.entity;

import javax.xml.bind.annotation.XmlElement;

public class Table {

    private String deptId;
    private String deptName;
    private String parentId;

    public String getDeptId() {
        return deptId;
    }
    @XmlElement(name = "deptId")
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }
    @XmlElement(name = "deptName")
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentId() {
        return parentId;
    }
    @XmlElement(name = "parentId")
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Table{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
