package main.java.mai2;

import java.util.List;


public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> bList = new ArrayList<String>();
//		bList.add("sdfs");
//		bList.add("asd");
//		tt(bList);
		String date = "20210711";
		System.out.println(date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8));
		
	}
	
	
	public <T> void test1(List<T> list){
        System.out.println("== test1 output ==");
        System.out.println("list length: " + list.size());  //
        if (!list.isEmpty()) {
            T t = list.get(0); //list中的元素为T类型
            System.out.println("t = " + t);//
        }
    }

	public static void tt(final List<String> a) {

		StringBuffer ab = new StringBuffer();
		for (String string : a) {
			
			ab.append('\'').append(string).append('\'')
			.append(',');
		}
		String[] a1 = a.toArray(new String[a.size()]);
		System.out.println(ab.toString());
	}
}
