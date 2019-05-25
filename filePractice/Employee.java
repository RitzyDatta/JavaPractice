package filePractice;

import java.io.Serializable;
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4052765627222321960L;
	String Name, Address;
	String PhoneNumber;
	
	public Employee(String N, String A, String P) {
		Name=N;
		Address=A;
		PhoneNumber=P;
	}
}
