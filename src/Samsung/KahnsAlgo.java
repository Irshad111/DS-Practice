package Samsung;

import java.util.ArrayList;

import Samsung.Endoscope.Pair;

public class KahnsAlgo {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		for(int i=0;i<6;i++) {
			list.add(i,new ArrayList<>());
		}
		int v=6;
		list.get(5).add(2);
		list.get(5).add(0);
		list.get(4).add(0);
		list.get(4).add(1);
		list.get(2).add(3);
		list.get(3).add(1);
		topologicalSort(list,v);
		

	}
	/*
	 * Steps involved in finding the topological ordering of a DAG:

Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG 
and initialize the count of visited nodes as 0.

Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)

Step-3: Remove a vertex from the queue (Dequeue operation) and then.

       Increment count of visited nodes by 1.
       Decrease in-degree by 1 for all its neighboring nodes.
       If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
Step 5: Repeat Step 3 until the queue is empty.

Step 5: If count of visited nodes is not equal to the number of nodes in the graph then the 
topological sort is not possible for the given graph.

         How to find in-degree of each node?
         There are 2 ways to calculate in-degree of every vertex:
         Take an in-degree array which will keep track of
1) Traverse the array of edges and simply increase the counter of the destination node by 1.

for each node in Nodes
    indegree[node] = 0;
for each edge(src,dest) in Edges
    indegree[dest]++
Time Complexity: O(V+E)

2) Traverse the list for every node and then increment the in-degree of all the nodes connected to it by 1.

    for each node in Nodes
        If (list[node].size()!=0) then
        for each dest in list
            indegree[dest]++;
	 */
	public static void topologicalSort(ArrayList<ArrayList<Integer>> list,int V) {
		int indegree[]=new int[V];
		for(int i=0;i<V;i++) {
			ArrayList<Integer> nbrs=list.get(i);
			for(int node:nbrs) {
				++indegree[node];
			}
		}
		Queue q=new Queue();
		for(int i=0;i<V;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		int count=0;
		int []path=new int[V];
		int i=0;
		while(!q.isEmpty()) {
			int rm=q.remove();
			path[i++]=rm;
			
			for(int node :list.get(rm)) {
				if(--indegree[node]==0) {
					q.add(node);
				}
				
			}
			count++;
			
		}
		if(count!=V) {
			System.out.println(" Topological sorting not possible");
		}else {
			for(int node:path) {
				System.out.print(node+" ");
			}
		}
		
		
		
	}
	static class Queue{
		int [] data=new int[1000000];
		int rear;
		int front;
		Queue() {
			rear=0;
			front=0;
		}
		public void add(int item) {
			data[rear++]=item;
		}
		public int remove() {
			return data[front++];
		}
		public boolean isEmpty() {
			return front==rear;
		}
		
		
	}

}
