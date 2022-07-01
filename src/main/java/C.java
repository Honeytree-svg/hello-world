package main.java;

public class C {
	private String c;

	public C(String c) {
		this.c = c;
		System.out.printf("C is created by constructor");
	}
	
	public C() {
		this.c = " ";
		System.out.printf("C is created by default");
	}
	
	public void outPut() {
		System.out.printf("this is C");
	}
}
