package Array;
import java.util.*;
//import java.lang.*;
//import java.io.*;

class GFG {
	public static void main (String[] args) {
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0){
	    int n=sc.nextInt();
	    int arr[][]=new int[n][n];
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            arr[i][j]=sc.nextInt();
	        }
	    }
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            System.out.print(arr[n-j-1][i]+" ");
	        }
	    }
	    System.out.println();

	}
	}
}
