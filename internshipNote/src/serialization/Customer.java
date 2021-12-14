package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Customer implements Cloneable,Serializable{

	private String name;
	private int age;

	
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//序列化过程
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car1.ser"));
        Car car1 = new Car(175, "白色");
        oos.writeObject(car1);
        oos.close();

        //反序列化过程
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("car1.ser"));
        Car car2 = (Car) ois.readObject();
        System.out.println("car2:" + car2);
        ois.close();

	}
}
