package Samsung;


public class LLCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LinkedList list=new LinkedList();
	        list.addLast(1);
	        list.addLast(2);
	        list.addLast(3);
	        list.addLast(4);
	      list.head.next.next.next.next=list.head.next.next;
	        System.out.println(hasLoop(list.head));

	}
	public static boolean hasLoop(Node head)
    {
       
        Node slow=head;
        Node fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
        	 slow=slow.next;
             fast=fast.next.next;
            if(slow==fast){
                return true;
            }
           
        }
        return false;
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
	}

}

