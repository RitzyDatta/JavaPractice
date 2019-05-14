import com.linkedList.*;
import java.util.Scanner;

public class DriverClassLinkedList {

	public static void main(String[] args) {
		LinkedList<String> l1 = new LinkedList<String>();
		int num;
		String data;					//num contains how many nodes we wnat to insert
		String choice=null;
		boolean bool=true;
		Scanner sc = new Scanner(System.in);
		
		while(bool) {
			System.out.println("press 1 to insert nodes at last");
			System.out.println("press 2 to delete first node");
			System.out.println("press 3 to delete last node");
			System.out.println("press 4 to reverse the list");
			
			System.out.println("press 5 to insert nodes at first");
			System.out.println("press 6 to insert nodes at a specific position");
			
			System.out.println("press 7 to display list");
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
				int pos;
				System.out.println("Enter data" );
				data=sc.next();
				System.out.println("Enter position in number" );
				pos=sc.nextInt();
				l1.insertNodeatSpecfic(data,pos);
				break;
				
			case "7":
				l1.displayList();
				break;
				
			default:
				bool=false;
			}
		}

	}
}
