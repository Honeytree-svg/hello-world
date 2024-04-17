package webserviceclient.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "NewDataSet")
public class NewDataSet {


    private List<Table> tables;

    public List<Table> getTables() {
        return tables;
    }

    @XmlElement(name = "Table")
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "NewDataSet{" +
                "tables=" + tables +
                '}';
    }
}
