package Samsung;

import java.util.Scanner;

public class Endoscope {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn=new Scanner(System.in);
	        int T = scn.nextInt();
	        while (T-- > 0) {
	            int M = scn.nextInt();
	            int N = scn.nextInt();
	            int R = scn.nextInt();
	            int C = scn.nextInt();
	            int L = scn.nextInt();
	            
	            int[][] arr = new int[M][N];
	            
	            for (int i = 0; i < M; i++) {
	                for (int j = 0; j < N; j++) {
	                    arr[i][j] = scn.nextInt();
	                }
	            }
	            endscope(arr,M,N,R,C,L);
	        }
	            

		}
		
		public static void endscope(int arr[][],int M,int N,int x,int y,int len) {
			Queue q=new Queue();
			int dist[][]=new int[M][N];
			boolean visited[][]=new boolean[M][N];
			if(arr[x][y]!=0) {
				visited[x][y]=true;
				dist[x][y]=1;
				q.add(new Pair(x,y));
				
			}
			while(!q.isEmpty()) {
				Pair rm=q.remove();
				int x1=rm.x;
				int y1=rm.y;
				// up
				if(x1-1>=0 && up(arr,x1,y1)&& down(arr,x1-1,y1) && !visited[x1-1][y1]) {
					int d=dist[x1][y1]+1;
					if(d<=len) {
						q.add(new Pair(x1-1,y1));
						visited[x1-1][y1]=true;
						dist[x1-1][y1]=d;
					}
				}
				// down
				if(x1+1<M && down(arr,x1,y1) && up(arr,x1+1,y1) && !visited[x1+1][y1]) {
					int d=dist[x1][y1]+1;
					if(d<=len) {
						q.add(new Pair(x1+1,y1));
						visited[x1+1][y1]=true;
						dist[x1+1][y1]=d;
					}
				}
				// left
				if(y1-1>=0 && left(arr,x1,y1) && right(arr,x1,y1-1) && !visited[x1][y1-1]) {
					int d=dist[x1][y1]+1;
					if(d<=len) {
						q.add(new Pair(x1,y1-1));
						visited[x1][y1-1]=true;
						dist[x1][y1-1]=d;
					}
				}
				// right
				if(y1+1<N && right(arr,x1,y1) && left(arr,x1,y1+1) && !visited[x1][y1+1]) {
					int d=dist[x1][y1]+1;
					if(d<=len) {
						q.add(new Pair(x1,y1+1));
						visited[x1][y1+1]=true;
						dist[x1][y1+1]=d;
					}
				}
				
			}
			int count=0;
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(dist[i][j]>0) {
						count++;
					}
				}
			}
			System.out.println(count);
			
		}
		public static boolean up(int arr[][],int x,int y) {
			if(arr[x][y]==1 || arr[x][y]==2 || arr[x][y]==4 || arr[x][y]==7) {
				return true;
			}
			return false;
		}
		public static boolean down(int arr[][],int x,int y) {
			if(arr[x][y]==1 || arr[x][y]==2 || arr[x][y]==5 || arr[x][y]==6) {
				return true;
			}
			return false;
		}
		public static boolean left(int arr[][],int x,int y) {
			if(arr[x][y]==1 || arr[x][y]==3 || arr[x][y]==6 || arr[x][y]==7) {
				return true;
			}
			return false;
		}
		public static boolean right(int arr[][],int x,int y) {
			if(arr[x][y]==1 || arr[x][y]==3 || arr[x][y]==4 || arr[x][y]==5) {
				return true;
			}
			return false;
		}
		static class Queue{
			Pair [] data=new Pair[1000000];
			int rear;
			int front;
			Queue() {
				rear=0;
				front=0;
			}
			public void add(Pair item) {
				data[rear++]=item;
			}
			public Pair remove() {
				return data[front++];
			}
			public boolean isEmpty() {
				return front==rear;
			}
			
			
		}
		static class Pair{
			int x;
			int y;
			Pair(int x,int y){
				this.x=x;
				this.y=y;
			}
		}

}
