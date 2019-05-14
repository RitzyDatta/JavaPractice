/* The choices in while loop only accept integer. */

import java.util.*;


public class LinkedList {
	class Node{
		int data;
		Node next;
		
		Node(int item){
			data=item;
			next=null;
		}
	}
	
	Node head=null;
	Node end=null;
	
	public void insertNode(int item) { // this will add node in linked list in any position. 
												// Here item will contain data value of the node.
		Node newNode= new Node(item);
		if (head == null) {
			head=end=newNode;
		}
		else {
			end.next=newNode;
			end=newNode;
		}
		
	} // end of insertNode
	
	public void deleteFirstNode() {  // this function will delete the first node of the list
		if(head==null) {
			System.out.println("List is empty");
		}
		else {
			Node temp=head;
			
			if(head==end) {
				head=end=null; // list contain only one element.
			}
			else {

				head=temp.next;
				temp=null;
			}
		}
		
	}
	
	public void deleteLastNode() {  // this function will delete the last node of the list
		
		if(head==null) {
			System.out.println("List is empty");
		}
		else {
			Node temp=head; //  temp1 is pointing to second node and temp is pointing to the first node1
			
			
			if(head==end) {
				head=end=null;
			}
			else {
				while(temp.next != end) {
					temp=temp.next;
				}
				end=temp;
				end.next=null;
				
				temp=temp.next;
				temp=null;//free the last node
				
			}
		}
		
	}
	
	public void reverseList() {
		Node tmp1,tmp2,tmp3;
		tmp1=head;
		tmp2=head.next;
		tmp3=tmp2.next;
		
		while(tmp3.next!=null) {
			if(tmp1==head)
				tmp1.next=null;
			tmp2.next=tmp1;
			tmp1=tmp2;
			tmp2=tmp3;
			tmp3=tmp3.next;
		}
		tmp2.next=tmp1;
		tmp1=tmp2;
		tmp2=tmp3;
		
		tmp2.next=tmp1;
		
		end = head;
		head = tmp2;
		
		
	}
	
	public void displayList() {  // this function will display the entire list
		Node temp=head;
		
		if(head==null)
			System.out.println("List is empty");
		else {
			System.out.println("Full list is : ");
			while(temp!= null) {
				System.out.print(temp.data + "\t");
				temp=temp.next;
			}
			System.out.print("\n");
		}
		
	} //end of displayList
	

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		int num, data;					//num contains how many nodes we wnat to insert
		int choice=0;
		boolean bool=true;
		Scanner sc = new Scanner(System.in);
		
		while(bool) {
			System.out.println("press 1 to insert nodes");
			System.out.println("press 2 to delete first node");
			System.out.println("press 3 to delete last node");
			System.out.println("press 4 to reverse the list");
			System.out.println("press 5 to display list");
			System.out.println("press any other key to exit the program");
			
			try {
			choice=sc.nextInt();
			}
			catch(Exception e) {
				//System.out.println("this program only accept integer");
			}
			
			switch(choice) {
			case 1:
				System.out.println("How many nodes you want to insert?");
				num=sc.nextInt();
				for(int i=0;i<num;i++) {
					System.out.println("Enter data" + i + ": ");
					data=sc.nextInt();
					l1.insertNode(data);	
					
				}
				break;
			
			case 2:
				l1.deleteFirstNode();
				break;
			case 3:
				l1.deleteLastNode();
				break;
			case 4:
				l1.reverseList();
				break;
				
			case 5:
				l1.displayList();
				break;
				
			default:
				bool=false;
			}
		}
		
		

	}

}
