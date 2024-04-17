package main.java.collection;

public class Contact {

    private String id;
    private String telephone;
    public Contact() {
        
    }
    public Contact(String id, String telephone) {
        
        this.id = id;
        this.telephone = telephone;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    @Override
    public String toString() {
        return "Contact [id=" + id + ", telephone=" + telephone + "]";
    }
    
    
}
