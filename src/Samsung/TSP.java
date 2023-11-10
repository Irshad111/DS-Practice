package Samsung;

import java.util.*;

public class TSP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc=new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t-->0){
		     int n=sc.nextInt();
		     
		     int [][]graph=new int[n][n];
		     for(int i=0;i<n;i++){
		         for(int j=0;j<n;j++){
		             graph[i][j]=sc.nextInt();
		         }
		     }
		     
		     
		     boolean vis[]=new boolean[n];
		     
		     // add 0
		     vis[0]=true;
		     int ans=Integer.MAX_VALUE;
		      ans=tsp(graph,vis,0,n,1,0,ans);
		         System.out.println(ans);
		     
		 }
		 sc.close();
		 }
		 public static int tsp(int [][]graph,boolean[] vis,int pos,int V,int count,int cost,int ans){
		     if(count==V && graph[pos][0]>0){
		         ans=Math.min(ans,cost+graph[pos][0]);
		         return ans;
		     }
		     for(int v=0;v<V;v++){
		         if(!vis[v] && graph[pos][v]>0){
		             vis[v]=true;
		             ans=tsp(graph,vis,v,V,count+1,cost+graph[pos][v],ans);
		             vis[v]=false;
		         }
		     }
		     return ans;

}
}
