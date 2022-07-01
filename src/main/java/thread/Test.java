package main.java.thread;

public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName() + "被调用。");
			}
		});
		thread.start();
		String aString = "a";
		
	}

}
