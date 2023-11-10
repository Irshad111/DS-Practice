package Samsung;

import java.io.*;
/*
Input:
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
10
39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36
OutPut:
#1 200
#2 304
#3 366
*/

public class Refrigertor {
     static int ans;
	public static void main(String[] args) throws IOException{
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		int n=Integer.parseInt(br.readLine());
//		String []str=br.readLine().split(" ");
//		int x[]=new int[n+2];
//		int y[]=new int[n+2];
//		
//		int i=0;
//		//  src
//		x[0]=Integer.parseInt(str[i++]);
//		y[0]=Integer.parseInt(str[i++]);
//		// dest
//		x[n+1]=Integer.parseInt(str[i++]);
//		y[n+1]=Integer.parseInt(str[i++]);
//		// other location
//		for(int j=1;j<=n;j++) {
//			x[j]=Integer.parseInt(str[i++]);
//			y[j]=Integer.parseInt(str[i++]);
//		}
//		int n=5;
//		int []x= {0,70,30,10,90,50,100};
//		int []y= {0,40,10,5,70,20,100};
		int n=6;
		int []x= {88,19,31,27,30,20,5,85};
		int []y= {81,22,15,29,10,26,14,80};
		ans=Integer.MAX_VALUE;
		boolean vis[]=new boolean[n+2];
		path(vis,x,y,n,0,0,0);
		System.out.println(ans);
		
		

	}
	public static void path(boolean [] vis,int[] x,int []y,int n,int count,int parent,int cost) {
		if(n==count) {
			ans=min(ans,cost+dist(x,y,parent,n+1));
			return;
		}
		for(int child=1;child<=n;child++) {
			if(!vis[child]) {
				vis[child]=true;
				path(vis,x,y,n,count+1,child,cost+dist(x,y,child,parent));
				vis[child]=false;
			}
		}
		
		
	}
	public static int dist(int []x,int []y,int i,int j) {
		int x1=x[i],x2=x[j];
		int y1=y[i],y2=y[j];
		return abs(x1-x2)+abs(y1-y2);
	}
	public static int abs(int x) {
		if(x>0) {
			return x;
		}
		return -x;
	}
	public static int min(int x,int y) {
		return x<y?x:y;
	}
	

}
