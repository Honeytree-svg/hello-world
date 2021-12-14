package classLoaderandforname;

public class AAA {
	
	public static int count;
	
	public void hahaha() {
		System.out.println("hahahahahahah~");
	}
	
	private AAA() {
		System.out.println(++count);
	}

	static {
		System.out.println("Loading Object...");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {
			
			Class<?> class1 = classLoader.loadClass("classLoaderandforname.AAA");
			//AAA aaa = (AAA)class1.newInstance();
			//aaa.hahaha();
			
			System.out.println(" --------------------------");
			
			
			Class fornameClass = Class.forName("classLoaderandforname.AAA");
			//AAA bbb = (AAA)fornameClass.newInstance();
			System.out.println(" --------------------------");
			
			//AAA ccc = new AAA();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
