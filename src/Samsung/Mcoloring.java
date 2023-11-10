package Samsung;

import java.util.Scanner;

public class Mcoloring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc=new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t-->0){
		     int V=sc.nextInt();
		     int m=sc.nextInt();
		     int e=sc.nextInt();
		     int [][]graph=new int[V][V];
		     for(int i=1;i<=e;i++){
		         int a=sc.nextInt();
		         int b=sc.nextInt();
		         graph[a-1][b-1]=1;
		         graph[b-1][a-1]=1;
		     }
		     int color[]=new int[V];
		     if(graphColor(graph,m,color,0,V)){
		         System.out.println("1");
		     }else{
		        System.out.println("0"); 
		     }
		 }
		 
		 }
		 public static boolean graphColor(int graph[][],int m,int []color,int v,int V){
		     if(v==V){
		         return true;
		     }
		     for(int c=1;c<=m;c++ ){
		         
		         if(isSafe(graph,v,color,c,V)){
		             color[v]=c;
		             if(graphColor(graph,m,color,v+1,V)){
		                 return true;
		             }
		             color[v]=0;
		         }
		     }
		     return false;
		     
		 }
		 public static boolean isSafe(int graph[][],int v,int []color,int c,int V){
		     for(int i=0;i<V;i++){
		         if(graph[v][i]==1 && color[i]==c){
		             return false;
		         }
		     }
		     return true;
		 }
	

}
