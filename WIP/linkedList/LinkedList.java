package com.linkedList;

public class LinkedList<T> {
	class Node{
		T data;
		Node next;
		
		Node(T item){
			data=item;
			next=null;
		}
	}
	
	Node head=null;
	Node end=null;
	
	public boolean insertNodeatEnd(T item) { // this will add node in linked list in any position. 
										// Here item will contain data value of the node.
		Node newNode;
		try {
		 newNode =new Node(item);
		}
		catch(Exception e) {
			return false;
		}
		if (head == null) {
			head=end=newNode;
			return true;
		}
		else {
			end.next=newNode;
			end=newNode;
			return true;
		}

	} // end of insertNodeatEnd
	
	public boolean insertNodeatStart(T item) { // this will add node in linked list in any position. 
		// Here item will contain data value of the node.
		Node newNode;
		try {
			newNode =new Node(item);
		}
		catch(Exception e) {
			return false;
		}
		if (head == null) {
			head=end=newNode;
			return true;
		}
		else {
			newNode.next=head;
			head=newNode;
			return true;
		}
		} // end of insertNodeatStart
	
	public boolean insertNodeatSpecfic(T item, int pos) {
		
		Node newNode,temp;
		temp=head;
		try {
			newNode =new Node(item);
		}
		catch(Exception e) {
			return false;
		}
		
		if(head==null) { //check if the list is empty
			if(pos==1) {
				head=end=newNode;
				return true;
			}
			else
				return false;
		}
		else {
			for(int i=1;i<pos;i++) {
				if(temp == null) {
					return false;
				}
				else {
					temp=temp.next;
				}
			}
			newNode.next=temp.next;
			temp.next=newNode;
			
			return true;
		}
		
	
	}
	
	public boolean deleteFirstNode() {  // this function will delete the first node of the list
		if(head==null) {
			return false;
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
			return true;
		}
		
	}
	
	public boolean deleteLastNode() {  // this function will delete the last node of the list
		
		if(head==null) {
			return false;
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
			return true;
		}
		
	}
	
	public boolean reverseList() {
		
		if(head==null) {
			return false;
		}
		else {
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
			
			return true;
		}
		
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


}
