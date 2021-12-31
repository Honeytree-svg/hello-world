package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
	
	static boolean flagA = true;
	static boolean flagB = true;
	static boolean flagC = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runnable1=new Runnable() {
			
			int []array = new int[4096];
			
		    @Override
		    public void run() {
		    	
		    	for (int i = 0; i < array.length; i++) {
					array[i] = i;
				}
		    	flagA = false;
		    	while(flagB)System.out.println("waiting Thread2");
		    	while(flagC)System.out.println("waiting Thread3");
		    	for (int i = 0; i < array.length; i++) {
		    		System.out.println("数组：" + array[i]);
				}
		    	System.out.println("数组遍历完毕！");
		    }
		    
		    private void init() {
				
			}
		};
		
		Runnable runnable2=new Runnable() {
		    @Override
		    public void run() {
		    	List<Integer> list = new ArrayList<Integer>(4096);
		    	for (int i = 0, j = list.size(); i < j; i++) {
					list.add(i);
				}
		    	flagB = false;
		    	while(flagA)System.out.println("waiting Thread1");
		    	while(flagC)System.out.println("waiting Thread3");
		    	for (int i = 0; i < 4096; i++) {
		    		System.out.println("ArrayList：" + list.get(i));
				}
		    	System.out.println("ArrayList遍历完毕！");
		    }
		};
		
		Runnable runnable3=new Runnable() {
		    @Override
		    public void run() {
		    	Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		    	for (int i = 0; i < 4096; i++) {
					hashMap.put(i, i);
				}
		    	flagC = false;
		    	while(flagA)System.out.println("waiting Thread1");
		    	while(flagB)System.out.println("waiting Thread2");
		    	for (int i = 0; i < 4096; i++) {
		    		System.out.println("HashMap：" + hashMap.get(i));
				}
		    	System.out.println("HashMap遍历完毕！");
		    }
		};
		Thread originArray = new Thread(runnable1);
		Thread arrayList = new Thread(runnable2);
		Thread hashMap = new Thread(runnable3);
		arrayList.start();
		originArray.start();
		hashMap.start();
	}

}
