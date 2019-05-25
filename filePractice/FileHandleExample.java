/**
 * This program writes the value of a object Employee in a text file
 */


package filePractice;
import java.util.*;
import java.io.*;

public class FileHandleExample {

	public static void main(String[] args) {
		int num;
		String Name, Address,PhoneNumber;
		List <Employee> empList = new ArrayList<>();
		FileWriter writer;
		BufferedWriter buffer;

		Scanner sc=new Scanner(System.in);
		System.out.println("How many records you want to insert?");
		num=sc.nextInt();
		
		try {
			File empDetails= new File("D:\\Practice\\java\\employeeDetails.txt"); // create a new file
			if(empDetails.createNewFile()) 
				System.out.println("New File is created!");  
            else   
                System.out.println("Writing on existing file");  // if file exist, overwrite the existing file
              
        	}
		catch (IOException e) {  
            e.printStackTrace();  
        }		
		
		
		for(int i=1; i <= num; i++) {
			System.out.println("Enter details for Employee" +i);
			System.out.println("Name");
			Name=sc.next();
			System.out.println("Address");
			Address=sc.next();
			System.out.println("Mobile");
			PhoneNumber=sc.next();
			
			Employee emp=new Employee(Name, Address, PhoneNumber);
			empList.add(emp);
			
		}
		
		try {
			writer = new FileWriter("D:\\Practice\\java\\employeeDetails.txt"); 
			buffer = new BufferedWriter(writer);
			for(Employee emp1 : empList) {
				buffer.write(emp1.Name);
				buffer.newLine();		
				buffer.write( emp1.Address);
				buffer.newLine();
				buffer.write(emp1.PhoneNumber);
				buffer.newLine();buffer.newLine();
				
			}
			buffer.close();  
		    System.out.println("Successfully wrote"); 
		}
		catch (IOException e) {  
            e.printStackTrace();  
        }
	
	    
		
		 

	}

}
