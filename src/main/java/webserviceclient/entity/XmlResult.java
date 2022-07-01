package webserviceclient.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "diffgr")
public class XmlResult {

//    private NewDataSet newDataSet;
//
//    public NewDataSet getNewDataSet() {
//        return newDataSet;
//    }
//    @XmlElement(name = "NewDataSet")

    public List<Table> getTables() {
        return tables;
    }
    @XmlElementWrapper(name = "NewDataSet")
    @XmlElement(name = "Table")
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
//    public void setNewDataSet(NewDataSet newDataSet) {
//        this.newDataSet = newDataSet;
//    }

    private List<Table> tables;


}
