/**
 * This package represents linkedlist functions like - insert, delete, reverse, count
 */

package com.linkedList;
import java.util.*;
public class SinglyLinkedList<T> {
	class Node{
		T data;
		Node next;
		
		Node(T item){
			data=item;
			next=null;
		}
	}
	
	public Node head=null;
	public Node end=null;
	
	/**
	 * This function accept the value of the node as parameter and return a boolean result. if insertion is successful then it will return true
	 * otherwise it will return false.
	 * @param item
	 * @return
	 */
	
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
	
	/**
	 * This function will add a node at the starting position.
	 * On successful insertion it will return true otherwise it will return false.
	 * it will take value of the node as parameter
	 * @param item
	 * @return
	 */
	
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
	
	
	/**
	 * This function will insert a node at a specific position.
	 * On successful insertion it will return true otherwise it will return false.
	 * it will take value two parameters- value of the node, and the position where the node should be inserted.
	 * @param item
	 * @param pos
	 * @return
	 */
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
		
	
	} //end of insertNodeatSpecific
	
	/**
	 * This function will recursively add node at the end of the linked list.
	 * it will accept the value of the node as parameter and the starting position of the linked list.
	 * On successful insertion it will return true otherwise it will return false.
	 * @param item
	 * @return
	 */
	
	public boolean insertNodeRecursive(T item, Node temp) {
		
		
		if(temp.next==null || temp == null) {
			
			Node newNode;
			try {
				newNode =new Node(item);
			}
			catch(Exception e) {
				return false;
			}
			
			if(temp==null) {
				head=end=newNode;
				return true;
			}
			else {
				temp.next=newNode;
				end=newNode;
				return true;
			}
			
		}
		else {
			temp=temp.next;
			this.insertNodeRecursive(item,temp);
			return false;
		}
		
	} //end of insertNodeRecursive
	
	/**
	 * This function will delete the first node of the linked list.
	 * On successful deletion it will return true, otherwise it will return false.
	 * @return
	 */
	
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
		
	} //end of deleteFirstNode
	
	/**
	 * This function will delete the last node of the linked list.
	 * On successful deletion it will return true otherwise it will return false.
	 * @return
	 */
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
		
	} // end of deleteLastNode
	
	/**
	 * this function will delete a node at a specific position
	 * it will take the position of the node as parameter for delete
	 * on success it will return true, otherwise it will return false
	 * @return
	 */
	
	public boolean deleteSpecific(int pos) {
		if(head==null) 
			return false;
		else {
			Node temp=head;
			Node temp1=head.next;
			if(head==end ) {
				if(pos==1) {
					head=end=null;
					temp=null;
					return true;
				}
				else 
					return false;
			}
			else {
				int totalNodes=this.countNodes();
				
				if(pos>totalNodes)
					return false;
				else {
					for(int i =1; i<pos; i++) {
						temp=temp1;
						temp1=temp.next;
					}
					temp.next=temp1.next;
					temp1=null;
					return true;
			}
			}
		}
	}
	
	
	/**
	 * This function will reverse a linkedlist. 
	 * On success, it will return true, otherwise it will return false.
	 * @return
	 */
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
		
	} // end of reverse list
	
	/**
	 * This function will print the whole linked list.
	 */
	
	
	/**
	 * This function will count the number of nodes of a linked list.
	 * if there are no nodes in the list this function will return 0 otherwise it will return the number of nodes.
	 * @return
	 */
	public int countNodes() {
		Node temp=head;
		int count=0;
		if(head==null) {
			return count;
		}
		else {
			while (temp != null) {
				count++;
				temp = temp.next;
			}
			return count;
		}
		
	}//end of count nodes
	
	/**
	 * this function will take the search value of the node as argument.
	 * this function will return a list of integer to the calling function.
	 * if the value is found then the returned list will contain all the positions where value was found otherwise this list will be null.
	 * @param item
	 * @return
	 */
	
	public List<Integer> searchWithValue(T item) {
		List<Integer> position = new ArrayList<Integer>();
		Node temp=head;
		int pos,count=0;;
		
		if(temp==null) {
			return position;
		}
		else {
			while(temp != null) {
				count++;
				if(temp.data == item)
					position.add(count);				
			}
			return position;
		}
	} // end of search with values
	
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
