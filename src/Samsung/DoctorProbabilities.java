package Samsung;

import java.io.*;
/*
 * Input:
6 10 40 
0 1 0.3
0 2 0.7
2 2 0.2
2 3 0.8
1 3 1.0
3 4 0.9
3 3 0.1
4 5 1.0
5 2 0.5
5 5 0.5
0
Output:5 0.774000
Input:
6 10 10 
0 1 0.3
0 2 0.7
2 2 0.2
2 3 0.8
1 3 1.0
3 4 0.9
3 3 0.1
4 5 1.0
5 2 0.5
5 5 0.5
0
Output:2 0.700000

 */
public class DoctorProbabilities {

	public static void main(String[] args)throws IOException {
		
		// TODO Auto-generated method stub
		BufferedReader  br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			String str[]=br.readLine().split(" ");
			int n=Integer.parseInt(str[0]);
			int e=Integer.parseInt(str[1]);
			int time=Integer.parseInt(str[2]);
			
			double [][]graph=new double[n][n];
			
			for(int i=0;i<e;i++) {
				str=br.readLine().split(" ");
				int u=Integer.parseInt(str[0]);
				int v=Integer.parseInt(str[1]);
				graph[u][v]=Double.parseDouble(str[2]);
			}
			int startdivision=Integer.parseInt(br.readLine());
			double ans[]=new double[n];
			solve(graph,n,time,startdivision,1.0,ans);
			double finalprob=0.0;
			int final_div=-1;
			for(int i=0;i<n;i++) {
				if(ans[i]>finalprob) {
					finalprob=ans[i];
					final_div=i;
				}
			}
			System.out.println(final_div+"  "+ String.format("%.6f",finalprob));
			
			
		}
		

	}
	public static void solve(double [][]graph,int n,int time,int start,double p,double[] ans) {
		if(time<=0) {
			ans[start]+=p;
			return;
		}
		for(int i=0;i<n;i++) {
			if(graph[start][i]!=0) {
				p*=graph[start][i];
				solve(graph,n,time-10,i,p,ans);
				p/=graph[start][i];
			}
		}
		
	}
	

}
