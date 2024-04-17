package serialization;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Cloneable,Serializable{

	private String name;
	private int age;
	private Long id;

	
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
}
