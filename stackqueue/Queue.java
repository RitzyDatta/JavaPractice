/* front is facing to the right side and rear is facing to left side */

package stackqueue;

public class Queue<T> {
	T data;
	Queue rear;
	Queue front;
	Queue link;
	
	public Queue()
	{
		rear=null;
		front=null;
		link=null;
	}
	
	public boolean enqueue(T item) {
		Queue temp=new Queue();
		if(temp == null) {
			return false;
		}
		else {
			temp.data = item;
			
			if(this.front==null)
			{
				front=temp;
				rear=temp;
				front.link=null;
				rear.link=null;
			}
			else {
				if(front==rear)
					front.link=temp;
				rear.link=temp;
				rear=temp;
				temp=null;
			}
			
			return false;
		}
	}
	
	public T dequeue() {
		if(front==null)
			return null;
		else {
			Queue temp= front;
			front=front.link;
			
			if(front==null) {
				rear=null;
				return null;
			}
			else
				return (T) temp.data;
		}
	}
	
	public void display() {
		Queue temp = new Queue();
		temp=front;
		while(temp != null) {
			System.out.println(temp.data);
			temp=temp.link;
		}
	}

}
