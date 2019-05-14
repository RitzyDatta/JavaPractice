//Construct a binary tree from inorder and post order traversal and output the pre order trraversal 

import java.util.*;
//public class BinaryTree {
	class Node{
		int key;
		Node left, right;
		
		public Node(int data) {
			key=data;
			left=right=null;
		}
	}
	
	class BinaryTree{
		
		static int index;
		
		public BinaryTree(int value) {
			index = value;
		}
		
		Node construct_tree(int inorder[], int postorder[], int start, int end)
		{
			//if(start>end)
			if(index<0)
				return null;
			else {
				
				Node temp = new Node(postorder[index]);
				index--;
				if(start == end) 
					return temp;
					
				else {
					
					int index_value = search(inorder, start, end, temp.key);
					temp.right=construct_tree(inorder, postorder, index_value+1, end);
					temp.left= construct_tree(inorder,postorder, start, index_value-1);
				}
				return temp;
			}
			
		}
			
		int search(int inorder[],int start,int end,int temp) {
			int temp_index = -1;
			for(int i=0;i<=inorder.length;i++) {
				if(temp==inorder[i])
				{
					temp_index= i; 
					break; //- if I use "break statement under if clause will it work?
				}
			}
			return temp_index;
			
		}
			
		 void preorder(Node root) {
			 if(root == null) 
				 return; // what single return means?
			 
			 System.out.println(root.key);
			 preorder(root.left);
			 preorder(root.right);
		 }
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inorder[]=new int[] {4, 8, 2, 5, 1, 6, 3, 7};
		int postorder[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
		
		int len =inorder.length;
		len=len-1;
		
		BinaryTree tree = new BinaryTree(len);
		
		//System.out.println("inside main"+index);
		Node root = tree.construct_tree(inorder, postorder, 0, len);
		
		//System.out.println(root.left.key);
		System.out.println("PREORDER TRAVERSAL");
		
		if(root==null)
			System.out.println("NULL");			
		tree.preorder(root);
		

	}

}
