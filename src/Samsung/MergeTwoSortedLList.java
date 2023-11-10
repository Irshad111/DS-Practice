package Samsung;

//import Samsung.LinkedList.Node;

public class MergeTwoSortedLList {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1=new LinkedList();
		l1.addLast(10);
		l1.addLast(20);
		l1.addLast(30);
		l1.addLast(100);
		l1.addLast(110);
		l1.addLast(210);
		l1.display();
		
		LinkedList l2=new LinkedList();
		l2.addLast(5);
		l2.addLast(15);
		l2.addLast(25);
		l2.addLast(35);
		l2.addLast(45);
		l2.addLast(445);
		l2.addLast(555);
		l2.display();
		
		LinkedList merge=mergeTwoList(l1,l2);
		merge.display();
		
		

	}
	public static LinkedList mergeTwoList(LinkedList l1,LinkedList l2) {
		LinkedList merge=new LinkedList();
		Node one=l1.head;
		Node second=l2.head;
		while(one!=null && second!=null) {
			if(one.data<second.data) {
				merge.addLast(one.data);
				one=one.next;
			}else {
				merge.addLast(second.data);
				second=second.next;
			}
			
		}
		while(one!=null) {
			merge.addLast(one.data);
			one=one.next;
		}
		while(second!=null) {
			merge.addLast(second.data);
			second=second.next;
		}
		
		return merge;
	}
	public static class Node{
		Node next;
		int data;
	}
	public static class LinkedList{
		
		private  Node head;
		private Node tail;
		private int size;
		
		public void addLast(int item) {
			Node nn=new Node();
			nn.data=item;
			nn.next=null;
			
			if(this.size==0) {
				this.head=nn;
				this.tail=nn;
				this.size++;
				
			}else {
				this.tail.next=nn;
				this.tail=nn;
				this.size++;
			}
		}
		public void display() {
			System.out.println("-------------");
			Node temp = this.head;
			for (int i = 0; i < this.size; i++) {
				System.out.println(temp.data + " ");
				temp = temp.next;
			}
			System.out.println("--------------");

		}

	}

}


