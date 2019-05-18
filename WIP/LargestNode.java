
public class LargestNode {
	public class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int item) {
			data=item;
			next=prev=null;
		}
	}
	
	public Node root; //this is the root of the binary tree
	
	public LargestNode() {
		root=null;
	}
	
	public Node createNode(int item) {
		Node temp= new Node(item);
		return temp;
	}
	
	public int findLargest(Node temproot) {
		if(temproot==null) {
			System.out.println("Tree is empty");
			return 0;
		}
		else {
			int leftMax, rightMax;
			int max=temproot.data; //max will store the largest value of the tree
			
			if(temproot.prev != null) {
				leftMax=findLargest(temproot.prev);
				if(leftMax > max) {
					max=leftMax;
				}
			}
			if(temproot.next != null) {
				rightMax=findLargest(temproot.next);
				if(rightMax > max) {
					max=rightMax;
				}
			}
			
			return max;
		}
	}
}
