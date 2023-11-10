package Samsung;

import java.util.Scanner;

public class Spaceship {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		int mat[][]=new int[n][5];
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<5;j++) {
//				mat[i][j]=sc.nextInt();
//			}
//		}
		int n=6;
		int mat[][]= {
				{0,1,0,2,0},{0,0,0,0,1},{0,0,1,1,1},{1,0,1,0,0},{0,0,1,0,0},{1,1,0,0,1}
		};
		System.out.println(solve(mat,n,0,1,n,2));

	}
	public static int solve(int [][]arr,int n,int coin,int bomb,int row,int col) {
		if(row<0 || col<0 || col>=5) {
			return coin;
		}
		if(row!=n) {
			if(arr[row][col]==2) {
				return coin;
			}
			if(arr[row][col]==1) {
				coin++;
			}
				
		}
		
		if(bomb==1) {
			int [][]temp=new int[n][5];
			for(int i=0;i<n;i++) {
				for(int j=0;j<5;j++) {
					temp[i][j]=arr[i][j];
				}
			}
			
			int i=row;
			int count=5;
			while(count-->0 && i-->0) {
				for(int j=0;j<5;j++) {
					if(temp[i][j]==2) {
						temp[i][j]=0;
					}
				}
			}
			// if we don't use bomb
			int cb=solve(arr,n,coin,1,row-1,col);
			int lb=solve(arr,n,coin,1,row-1,col-1);
			int rb=solve(arr,n,coin,1,row-1,col+1);
			// if we used bomb then our matrix became temp
			int c=solve(temp,n,coin,0,row-1,col);
			int l=solve(temp,n,coin,0,row-1,col-1);
			int r=solve(temp,n,coin,0,row-1,col+1);
			int ans=max(max(c,max(l,r)),max(cb,max(lb,rb)));
			return ans;
		}else {
			int c=solve(arr,n,coin,0,row-1,col);
			int l=solve(arr,n,coin,0,row-1,col-1);
			int r=solve(arr,n,coin,0,row-1,col+1);
			return max(c,max(l,r));
			
		}
		
	}
	public static int max(int a, int b) {
		return a>b? a:b;
	}

}
