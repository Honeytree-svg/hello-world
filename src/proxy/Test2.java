package proxy;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test1 = new Test1();
		Task task = (Task)ProxyFactory.newInstance(test1);
		task.work("sdfs");
		task.getValue(2);
		//ThreadLocal<String>
	}

}
