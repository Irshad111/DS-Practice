package Samsung;

import java.util.Scanner;

public class NextGreaterNum {
	/*
	 * algo
	 * I) Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller
	 *  than the previously traversed digit. For example, if the input number is “534976”, we stop at 4 because 4 
	 *  is smaller than next digit 9. If we do not find such a digit, then output is “Not Possible”.

II) Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’. 
For “534976″, the right side of 4 contains “976”. The smallest digit greater than 4 is 6.

III) Swap the above found two digits, we get 536974 in above example.

IV) Now sort all digits from position next to ‘d’ to the end of number. The number that we get after sorting is the output. 
For above example, we sort digits in bold 536974. We get “536479” which is the next greater number for input 534976.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 //code
		 Scanner sc=new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t-->0){
		     int n=sc.nextInt();
		     int arr[]=new int[n];
		     for(int i=0;i<n;i++){
		         arr[i]=sc.nextInt();
		     }
		     nextgreater(arr);
		     System.out.println();
		 }
		 

	}
	 public static void swap(int []arr, int i,int j){
	     int temp=arr[i];
	     arr[i]=arr[j];
	     arr[j]=temp;
	 }
	 public static void nextgreater(int []arr){
	     int i;
	     int n=arr.length;
	     // traverse right to left to find if arr[i-1]<arr[i]
	     for(i=n-1;i>0;i--){
	         if(arr[i-1]<arr[i])
	         break;
	     }
	     if(i==0){
	         // System.out.println("not possible");
	     }
	     // to find next greater to x in right side of i-1
	     int x=arr[i-1],min=i;
	     for(int j=i+1;j<n;j++){
	         if(x<arr[j] && arr[j]<arr[min]){
	             min=j;
	         }
	     }
	     // swap arr[i-1] to arr[min];
	     swap(arr,min,i-1);
	     // sort arr i to n
	     for(;i<n-1;i++){
	         for(int j=i+1;j<n;j++){
	             if(arr[i]>arr[j]){
	                 int temp=arr[i];
	                 arr[i]=arr[j];
	                 arr[j]=temp;
	             }
	         }
	     }
	     for(int j=0;j<n;j++){
	         System.out.print(arr[j]+" ");
	     }
	 }

}
