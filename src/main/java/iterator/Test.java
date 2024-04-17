package iterator;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<String> a = null;
        a.stream().forEach(item ->{
            System.out.println(1);
        });
    }
    
    public static class Model{
        
        private List<String> list = new ArrayList<String>();
        private String a;
        public List<String> getList() {
            return list;
        }
        public void setList(List<String> list) {
            this.list = list;
        }
        public String getA() {
            return a;
        }
        public void setA(String a) {
            this.a = a;
        }
        
        public Model(String a) {
            
            this.a = a;
            list = new ArrayList<String>();
            list.add("123");
            list.add("456");
            list.add("789");
        }
        
        public Model() {
            
        }
        @Override
        public String toString() {
            return "Model [list=" + list + ", a=" + a + "]";
        }
        
        
    }

}
