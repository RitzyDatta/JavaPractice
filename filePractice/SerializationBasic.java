package filePractice;
import java.io.*;
import java.util.Scanner;

public class SerializationBasic {

	public static void main(String[] args) {
		
		String Name, Address,PhoneNumber;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee records:");
		
		System.out.println("Enter details for Employee");
		System.out.println("Name");
		Name=sc.next();
		System.out.println("Address");
		Address=sc.next();
		System.out.println("Mobile");
		PhoneNumber=sc.next();
		
		Employee emp=new Employee(Name, Address, PhoneNumber);
		
		try {
		  FileOutputStream fout=new FileOutputStream("D:\\Practice\\java\\serialization.txt");  
		  ObjectOutputStream out=new ObjectOutputStream(fout); 
		  out.writeObject(emp);  
		  out.flush();  
		  System.out.println("success");  
		  
		  out.close();
		}
		catch (IOException e) {  
            e.printStackTrace();  
        }
		
		
		try {
			ObjectInputStream deserial=new ObjectInputStream(new FileInputStream("D:\\Practice\\java\\serialization.txt"));  
			Employee emp1 = null;
			try {
				emp1 = (Employee)deserial.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			System.out.println(emp1.Name+" "+emp1.Address+" "+emp1.PhoneNumber );  
			
			deserial.close();
		}
		catch (IOException e) {  
            e.printStackTrace();  
        }
		

	}

}
