package hash;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Cloneable,Serializable{

	private String name;
	private int age;
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
		Customer a = new Customer();
		a.setAge(15);
		a.setName("1");
		Customer b = new Customer();
		b.setAge(15);
		b.setName("1");
		Set<Customer> set = new HashSet<Customer>();
		set.add(a);
		set.add(b);
		System.out.println(set.toString());
	}
}
