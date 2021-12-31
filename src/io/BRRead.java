package io;

import java.io.IOException;
import java.util.BitSet;
import java.util.TreeSet;

public class BRRead {
	
	   public static void main(String args[]) throws IOException{
//	      char c;
//	      String sc;
//	      // 使用 System.in 创建 BufferedReader 
//	      BufferedReader br = new BufferedReader(new 
//	                         InputStreamReader(System.in));
//	      System.out.println("输入字符, 按下 'q' 键退出.");
//	      // 读取字符
//	      do {
//	         sc =  br.readLine();
//	         System.out.println(sc);
//	      } while(sc.charAt(0) != 'q');
		   
//		   int b; 
//		      b = 48;
//		      System.out.write(b);
//		      System.out.write('\n');
		   
		   //printbinry(1111);
		   
//		   System.out.print(3&1);
//		   System.out.print(5&11);
//		   Stack<Integer> stack = new Stack<Integer>();
//		   stack.add(1);
//		   stack.push(2);
//		   int a = stack.peek();
		   
//		   Error error = new Error("有问题的");
//		   error.printStackTrace();
//		   System.out.println("sdfsd");
//		   ArithmeticException arithmeticException = new ArithmeticException("你这个不对");
//		   arithmeticException.printStackTrace();
		  
//		   int a = 1;
//		   try {
//			   a++;
//			   throw new ArithmeticException();
//			   //a/=0;
//			   //System.out.println(a);
//		   }catch(Exception e) {
//			   a = 10;
//			   e.printStackTrace();
//			   System.out.println(a);
//		   }finally {
//			   //a = 0;
//			   System.out.println(a);
//		   }
//		   System.out.println(a);
		   
		   BitSet set = new BitSet();
		   TreeSet<String> treeSet = new TreeSet<String>();
		   
		   //Collections.sort(list, c);
	   } 
	   
	    private static void printbinry(int num) {
		// TODO Auto-generated method stub
		
	    	int count = 31;//值为31
	        System.out.println(count);
	        while (count>=0) {
	            int bitnum = num>>count; //除去符号位，从最高位开始得到每一位
	            int byte2 = bitnum & 1; //和1进行与运算得到每一位的二进制数
	            System.out.print(byte2);
	            
	           if (count%4==0) {//每隔四位打印空格
	        	   System.out.print(" ");
	           }
	           
	           count--;
	       }
	        System.out.println();
	    }

		
}
