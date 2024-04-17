package main.java.mai;

import java.math.BigDecimal;
import java.util.List;


public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Animal animal = new Cat();
//		String string = "fe1762c9-7d33-4c4d-b314-e0cc482d86c4";
//		System.out.println(animal.let);
//		animal.eat();
//		String sfString = null;
//		if (sfString != null) {
//			
//		}
		BigDecimal a = new BigDecimal("1.10");
		System.out.println(a.stripTrailingZeros().toPlainString() + "%");
	}

	public static boolean isNotBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return false;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return true;
            }
        }
        return false;
    }
	
	public <T> void test1(List<T> list){
        System.out.println("== test1 output ==");
        System.out.println("list length: " + list.size());  //
        if (!list.isEmpty()) {
            T t = list.get(0); //list中的元素为T类型
            System.out.println("t = " + t);//
        }
    }

}
