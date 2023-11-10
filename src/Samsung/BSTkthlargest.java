package Samsung;

import java.util.Scanner;

public class BSTkthlargest {
	private class Node{
		int data;
		Node left;
		Node right;
		Node(int d){
			this.data=d;
			this.left=null;
			this.right=null;
		}
	}
	private Node root;
	BSTkthlargest(){
		this.root=null;
	}
	public void insert(int data){
		this.root=helperinsert(data,this.root);
	}

	private Node helperinsert(int data, Node root) {
		if(root==null) {
			return new Node(data);
		}
		if(root.data>data) {
			root.left=helperinsert(data,root.left);
		}else if(root.data<data) {
			root.right=helperinsert(data,root.right);
		}
		
		return root;
	}
	private class Mover{
	    int count=0;
	    }
	    public void kthLargest(int k)
	    {
	        //Your code here
	        
	        helper(this.root,k,new Mover());
	        
	    }
	    private void helper(Node root,int k,Mover m){
	        if(root==null || m.count>=k){
	            return;
	        }
	        helper(root.right,k,m);
	        m.count++;
	        if(m.count==k){
	            System.out.println(root.data);
	            return;
	        }
	        helper(root.left,k,m);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		int t=sc.nextInt();
//		while(t-->0) {
//			int n=sc.nextInt();
//			BSTkthlargest bt=new BSTkthlargest();
//			
//			for(int i=0;i<n;i++) {
//				bt.insert(sc.nextInt());
//			}
//			int k=sc.nextInt();
//			bt.kthLargest(k);
//		}
		BSTkthlargest bt=new BSTkthlargest();
		bt.insert(50);//50 30 20 40 70 60 80
		bt.insert(30);
		bt.insert(20);
		bt.insert(40);
		bt.insert(70);
		bt.insert(60);
		bt.insert(80);
		bt.kthLargest(3);
		

	}

}
