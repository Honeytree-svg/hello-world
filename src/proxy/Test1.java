package proxy;

public class Test1 implements Task{

	@Override
	public void work(String data) {
		// TODO Auto-generated method stub
		System.out.println(data);
	}

	@Override
	public int getValue(int i) {
		// TODO Auto-generated method stub
		return i*10;
	}

}
