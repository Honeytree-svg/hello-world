package main.java.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//        Set<String> strings = new HashSet<String>();
//        strings.add("123");
//        strings.add("456");
//        strings.add("789");
////        for (String string : strings) {
////            
////            if (string.equals("456")) {
////                
////                strings.remove(string);
////            }
////        }
//        
//        Iterator<String> main.java.iterator = strings.main.java.iterator();
//        while (main.java.iterator.hasNext()) {
//            String string = (String) main.java.iterator.next();
//            if (string.equals("456")) {
//                
//                main.java.iterator.remove();
//            }
//        }
//        strings.forEach(System.out::println);
        
        Set<Test.Model> list = new HashSet<Test.Model>();
        list.add(new Test.Model("1"));
        list.add(new Test.Model("2"));
        list.add(new Test.Model("3"));
        
        Iterator<Test.Model> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            Test.Model model = (Test.Model) iterator2.next();
            
            List<String> list2 = model.getList();
            for (String string : list2) {
                
                list2.add("1111");
                break;
            }
            
            System.out.println(model.toString());
        }
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
