
public class DriverClassLargestNode {

	public static void main(String[] args) {
		LargestNode test=new LargestNode();
		test.root= test.createNode(3);
		test.root.prev=test.createNode(5);
		test.root.next=test.createNode(77);
		test.root.prev.prev=test.createNode(66);
		test.root.prev.next=test.createNode(88);
		test.root.next.prev=test.createNode(87);
		test.root.next.next=test.createNode(70);
		
		int q = test.findLargest(test.root);
		
		if(q==0) {
			System.out.println("tree is empty");
		}
		else
			System.out.println("Largest element: " +q);

	}

}