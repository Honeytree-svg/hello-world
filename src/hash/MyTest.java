package hash;

public class MyTest {
	
	private String sd;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String str = "a";
		final MyTest test = new MyTest();
		test.setSd(str);

		String str2 = new String("a");

		String str3 = "a";
		
		
		if (str==str2) {
			System.out.println("aaaaaaaaaaaaaaaa");
		}
		if (str==str3) {
			System.out.println("bbbbbbbbbbbbbbb");
		}
		byte[] bytes = str3.getBytes();
		for (byte b : bytes) {
			System.out.print(b);
		}
		
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}


}
