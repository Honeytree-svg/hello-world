package main.java.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//序列化过程
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car1.ser"));
        Customer car1 = new Customer("sdf175", 123);
        oos.writeObject(car1);
        oos.close();

        //反序列化过程
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("car1.ser"));
        Customer car2 = (Customer) ois.readObject();
        System.out.println("car2:" + car2);
        ois.close();

	}

}
