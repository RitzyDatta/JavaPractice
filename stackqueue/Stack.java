package stackqueue;
import java.util.*;

public class Stack<T> {
	 T data;
	 Stack top; // indicate the top most element
	 Stack link; //indicate the next element of any node
	 
	public Stack(){
		 top=null;
		 link=null;
	 }
	 
	 public boolean push(T item) {
		 Stack temp = new Stack();
		 if(temp == null) {
			// System.out.println("Memory is full");
			 return false;
		 }
		 else {
		 temp.data= item;
		 temp.link=top;
		 top=temp;
		 temp=null;
		 return true;
		 }
		 
	 }
	 
	 public boolean pop() {
		 if(top == null) {
			// System.out.println("array is null");
			 return false;
		 }
		 else {
			 Stack temp = top;
			 temp = null;
			 top = top.link;
			 
			 if(top==null)
				 return false;
			 else
				 return true;
		 }
	 }
	 
	 public Stack peep() {
		 return top;
	 }
	 
	 public void display() {
		 if(top != null) {
			 Stack temp=top;
			 while(temp !=null) {
				 System.out.println(temp.data);
				 temp=temp.link;
			 }
		 }
	 }

}
