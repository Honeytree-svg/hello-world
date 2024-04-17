package main.java.classLoaderandforname;

public class Validation {

	private String str;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if ("sdf".equals(null)) {
			System.out.println("123");
		}else {
			System.out.println("456");
		}
		
		
		Validation validation = new Validation();
		validation.str = "DASAS";
		
		Validation b = new Validation();
		System.out.println(b.str);
	}

}
