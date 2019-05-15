import com.linkedList.*;

import java.util.*;

public class DriverClassLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
		int num;
		int pos;
		String data;					//num contains how many nodes we wnat to insert
		String choice=null;
		boolean bool=true; // for while loop
		Scanner sc = new Scanner(System.in);
		
		while(bool) {
			System.out.println("1 to insert nodes at last");
			System.out.println("2 to delete first node");
			System.out.println("3 to delete last node");
			System.out.println("4 to reverse the list");
			
			System.out.println("5 to insert nodes at first");
			System.out.println("6 to insert nodes at a specific position");
			
			System.out.println("7 to insert node recursively");
			System.out.println("8 to count number of nodes");
			System.out.println("9 to search with a value");
			System.out.println("10 delete at specific position");
			
			System.out.println("11 to display list");
			System.out.println("press any other key to exit the program");
			
			try {
			choice=sc.next();
			}
			catch(Exception e) {
				//System.out.println("this program only accept integer");
			}
			
			switch(choice) {
			case "1":
				System.out.println("How many nodes you want to insert?");
				num=sc.nextInt();
				for(int i=0;i<num;i++) {
					System.out.println("Enter data" + i + ": ");
					data=sc.next();
					l1.insertNodeatEnd(data);	
					
				}
				break;
			
			case "2":
				l1.deleteFirstNode();
				break;
			case "3":
				l1.deleteLastNode();
				break;
			case "4":
				l1.reverseList();
				break;
				
			case "5":
				System.out.println("Enter data" );
				data=sc.next();
				l1.insertNodeatStart(data);	
				break;
			case "6":
				
				boolean bool1;
				System.out.println("Enter data" );
				data=sc.next();
				System.out.println("Enter position in number" );
				pos=sc.nextInt();
				bool1 = l1.insertNodeatSpecfic(data,pos);
				
				if(bool==false) {
					System.out.println("Insertion not possible");
				}
				break;
			
			case "7":
				System.out.println("Enter data" );
				data=sc.next();
				
				l1.insertNodeRecursive(data, l1.head);
				break;
			
			case "8":
				int count;
				count=l1.countNodes();
				
				if(count == 0)
					System.out.println("List is empty" );
				else
					System.out.println("Count is: " + count );
				break;
				
			case "9":
				System.out.println("Enter the value to serach" );
				data=sc.next();
				
				List<Integer> temp = l1.searchWithValue(data);
				
				if(temp==null) {
					System.out.println("This value is not present in the list" );
				}
				else {
					System.out.print("Value found at the position: " );
					for(Integer i : temp) {
						System.out.print(i + "\t" );
					}
					System.out.print("\n" );
				}
				
				break;
				
			case "10":
				System.out.println("Enter position(in number) to delete" );
				pos=sc.nextInt();
				bool1=l1.deleteSpecific(pos);
				
				if(bool1==false)
					System.out.print("Deletion is not possible " );
				
			case "11":
				l1.displayList();
				break;
				
			default:
				bool=false;
			}
		}

	}
}
