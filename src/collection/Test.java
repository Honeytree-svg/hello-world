package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Set<Contact> contatSet = new HashSet<Contact>();
        for (int i = 0; i < 5; i++) {
            String id = String.valueOf(i);
            contatSet.add(new Contact(id, id +id + id));
        }
        
        List<Contact> list = new ArrayList<Contact>();
        //list.sort((o1,o2) -> o1 -o2);
        
        for (Contact contact : contatSet) {
            
            if (contact.getId().equals("2")) {
                
                contatSet.remove(contact);
            }
            
            System.out.println(contact.toString());
        }
    }

}
