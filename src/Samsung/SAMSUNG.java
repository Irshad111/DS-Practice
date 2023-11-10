package Samsung;

public class SAMSUNG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * 
	 * Q.1.
	 * You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
Note: Expected solution in O(n) time using constant extra space.

Input:
First line consists of T test cases. First line of every test case consists of N, denoting the number of elements in array. Second line of every test case consists of elements in array.

Output:
Single line output, print the smallest positive number missing.

Constraints:
1 <= T <= 100
1 <= N <= 106
-106 <= arr[i] <= 106

Example:
Input:
2
5
1 2 3 4 5
5
0 -10 1 3 -20
Output:
6
2

Explanation:
Testcase 1: Smallest positive missing number is 6.
Testcase 2: Smallest positive missing number is 2.
	 */
	
	 public static int missingNum(int []arr,int n){
	     // if 1 is not exist
	     boolean firstexists=false;
	     for(int i:arr){
	         if(i==1)
	         firstexists=true;
	     }
	     if(!firstexists) return 1;
	     if(n==1) return 2;
	     // if any value is -ve or greater than n than put 1;
	     for(int i=0;i<n;i++){
	         if(arr[i]<=0 || arr[i]>n){
	             arr[i]=1;
	         }
	     }
	     // mark all value which is parsent using index
	     for(int i=0;i<n;i++){
	         int idx=Math.abs(arr[i]);
	         if(idx==n){
	         arr[0]=-1*Math.abs(arr[0]);
	         }
	         else{
	             arr[idx]=-1*Math.abs(arr[idx]);
	         }
	     }
	     // return index if its find +ve value
	     for(int i=1;i<n;i++){
	         if(arr[i]>0){
	             return i;
	         }
	     }
	     if(arr[0]>0){
	         return n;
	     }
	     return n+1;
	     

	 }
	 
	 /*
	  * 
	  * Q.2.
	  * A binary matrix of nxm was given, you have to toggle any column k number of times so that you can get the maximum number of rows having all 1’s.

for eg, n=3, m=3,

1 0 0

        1 0 1

        1 0 0
if k=2, then we will toggle column 2 and 3 once and we will get rows 1 and 3 with 1 1 1 and 1 1 1 i.e. all 1’s so answer is 2 as there are 2 rows with all 1’s.

if k=3, then we will toggle column 2 thrice and we will get row 2 with 1 1 1 i.e. all 1’s so answer is 1 as there is 1 row with all 1’s.

Please help me solve this question !
	  */
	 
	 /*
	  * solution
	  https://stackoverflow.com/questions/7116438/algorithms-question-flipping-columns
	  Using this, we get the following algorithm:

Maintain a hash table mapping from candidate rows to their frequency.
For each row:
Count the number or zeros in the row.
If the difference between k and this number is a nonnegative even number, update the hash table by incrementing the frequency of this particular row.
Find the candidate row in the hash table with the greatest total frequency.
Output the frequency of that row.
	  */

	 public static int pow(int x,int n) {
		     if(n==0) 
			 return 1;
			 int p=pow(x,n/2);
			 if(n%2==0)
				 return p*p;
			 else
				 return p*p*x;
		 
	 }
	 public static int flippingColumns(int n,int m,int[][] matrix,int k) {
		 int size=pow(2,m);
		 int []hash=new int[size];
		 for(int i=0;i<n;i++) {
			 int numzero=0;
			 int keyvalue=0;
			 for(int j=0;j<m;j++) {
				 keyvalue+=matrix[i][j]*pow(2,j);
				 if(matrix[i][j]==0) {
					 numzero++;
				 }
			 }
			 int temp=k-numzero;
			 if(temp>=0 && temp%2==0) {
				 hash[keyvalue]+=1;
			 }
		 }
		 
		 int keywithmaxval=-1,maxval=0;
		 for(int i=0;i<size;i++) {
			 if(hash[i]>maxval) {
				 maxval=hash[i];
				 keywithmaxval=i;
			 }
		 }
		 if(keywithmaxval==-1) {
			 return -1;
		 }
		 return maxval;
	 }
}
