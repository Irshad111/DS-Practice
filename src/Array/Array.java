package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Array {
	/*
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0){
	     int n=sc.nextInt();
	     int sum=sc.nextInt();
	     int arr[]=new int[n];
	     for(int i=0;i<n;i++){
	     arr[i]=sc.nextInt();
	     }
	     System.out.println(tripleSum(arr,sum));
	 }
	 
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
        int t=Integer.parseInt(br.readLine()); 
        while(t-->0){ 
            
        int n=Integer.parseInt(br.readLine()); 
        int arr[]=new int[n]; 
        String line=br.readLine(); 
        String str[]=line.split(" "); 
          for(int i=0;i<n;i++){
          arr[i]=Integer.parseInt(str[i]);
       }       
  
	     System.out.println(equilibiriumPoint(arr));
	 }
	 */

	public static void main(String arg[]) {
//		ArrayList<Integer> list=new ArrayList<>();
//		list.add(0);
//		list.add(9);
//		list.add(9);
		int [] arr= {1,3,2,2,4,4,9,6 };
		
		//System.out.println(maxSubArray(arr));
		//int arr1[]=missing(arr);
		
	        
//		ArrayList<Integer> ans=plusOne(list);
//		System.out.println("----");
//	for(int i: arr1) 
//		System.out.println(i);
//	
		
//		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		 int[] one = { 10,20,10,60,50 };
//				 int[] two = { 60,70,30,40,10,10 };
//				
//				 System.out.println(intersectionTwoLoops(one, two));
//		display(arr);
//		int[] arr1 = rotate(arr, -3);
//		display(arr)
//		display(arr1);
//		ArrayList<Integer> list=new ArrayList();
//		list.add(10);
//		list.add(20);
//		list.add(30);
//		list.add(40);
//		list.add(50);
//		list.add(60);
//		System.out.println(list.get(0));
//		list.add(2, 5);
//		System.out.println(list);
//		System.out.println(list.size());
//	for(int i=0;i<list.size()-1;i++) {
//		System.out.print(list.get(i)+" ");
//	}
//	for(int i:list) {
//		System.out.println(i);
//	}
//	list.remove(2);
//	System.out.println(list);

	}

	public static void display(int[] arr) {
		System.out.println("-----------");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("------------");
	}

	public static int[] rotate(int[] arr, int r) {
		r = r % arr.length;
		if (r < 0) {
			r = r + arr.length;
		}
		int[] ans = new int[arr.length];
		for (int i = 0; i < ans.length; i++) {
			if (i < r) {
				ans[i] = arr[i + arr.length - r];
			} else
				ans[i] = arr[i - r];
		}
		return ans;

	}
	public static ArrayList<Integer> intersection(int[] one, int[] two){
		ArrayList<Integer> ans=new ArrayList<>();
		int i=0;
		int j=0;
		while(i<one.length && j<two.length) {
			if(one[i]<two[j]) {
				i++;
			}else if(one[i]>two[j]) {
				j++;
			}else {
				ans.add(one[i]);
				i++;
				j++;
			}
		}
		return ans;
		
	}
	public static ArrayList<Integer> intersectionTwoLoops(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < one.length; i++) {

			for (int j = 0; j < two.length; j++) {

				if (one[i] == two[j]) {
					ans.add(one[i]);
					two[j] = Integer.MAX_VALUE;
					break;
				}
			}
		}

		return ans;

	}
	
	// Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
	 public static void subArray(int[] arr,int sum){
	     
	        int curr_sum =0, start = 0,flag=0; 
	  
	        // Pick a starting point 
	        for (int i = 0; i <arr.length; i++)  
	        {   
	            curr_sum = curr_sum + arr[i];
	            
	            // If curr_sum exceeds the sum, then remove the starting elements 
	            while (curr_sum > sum && start < i) 
	            { 
	                curr_sum = curr_sum - arr[start]; 
	                start++; 
	            }
	            if (curr_sum == sum)  
	            { flag=1;
	               System.out.println(start+1+" "+(i+1)); 
	               break;
	            }
	             
	              
	        } 
	         if(flag==0)
		     System.out.println("-1");
		         
		     
		 }
	// 
	public static void maxSubArray(int[] A) {
        int sum=A[0];
        int track=A[0];
        for(int i=1;i<=A.length-1;i++){
            track=Math.max(A[i],track+A[i]);
            System.out.println(track);
            sum=Math.max(sum,track);
            System.out.println(sum);
        }
        System.out.println(sum);
       // return sum;
    }
	//
	public static int[] maxset(int[] A) {
		int start=0,k=0;
		int end=0;
		long max_sum=0;
		long cur_sum=0;
		int flag=0;
		for(int i=0;i<A.length;i++) {
			if(A[i]>=0) {
				flag=1;
				cur_sum+=A[i];
				if(max_sum<cur_sum) {
					max_sum=cur_sum;
					start=k;
					end=i;
				}
				else if(max_sum==cur_sum) {
					if(end-start<i-k) {
						start=k;
						end=i;
					}
				}
			}
			else{
					k=i+1;
					cur_sum=0;
				}

				
    }
		if(flag==1) {
		int [] ans=new int[end-start+1];
		for(int i=0;i<ans.length;i++) {
			ans[i]=A[i+start];
		}
		return ans;
		}
		else
			return new int[0];

	}
	
	 //Triplet Sum in Array
	public static int tripleSum(int []arr,int sum){
	     int n=arr.length;
	     Arrays.sort(arr);
	     for(int i=0;i<n-2;i++){
	         int l=i+1;
	         int r=n-1;
	         while(l<r){
	             if(arr[i]+arr[l]+arr[r]==sum){
	            	 l++;
	            	 r--;
	                 return 1;
	             }else if(arr[i]+arr[l]+arr[r]<sum){
	                 l++;
	             }else{
	                 r--;
	             }
	         }
	     }
	     return 0;
	 }
	//
	public static int kadansAlgo(int arr[]) {
		int curr_max=arr[0],global_max=arr[0];
		for(int i=1;i<arr.length;i++) {
			curr_max=Math.max(arr[i],arr[i]+curr_max);
			if(curr_max>global_max) {
				global_max=curr_max;
			}
		}
		return global_max;
	}
	
	//merge two sorted array without extra space
	 public static int nextgap(int gap){
	     if(gap<=1){
	         return 0;
	     }
	     return (gap/2+gap%2);
	 }
	 public static void merge(int[]arr1,int []arr2,int n,int m){
	     int i,j,gap=n+m;
	     while((gap=nextgap(gap))>0){
	         // if gap<arr1.length then camparing element in arr1;
	         for( i=0;i+gap<n;i++){
	             if(arr1[i]>arr1[gap+i]){
	                 int temp=arr1[i];
	                 arr1[i]=arr1[gap+i];
	                 arr1[gap+i]=temp;
	             }
	         }
	         // gap>arr1.length then comparing in both array
	         for(j=gap>n?gap-n:0;i<n && j<m;j++,i++){
	             if(arr1[i]>arr2[j]){
	                 int temp=arr1[i];
	                 arr1[i]=arr2[j];
	                 arr2[j]=temp;
	             }
	         }
	         // comparing element in arr2 if j<m
	         if(j<m){
	             for(j=0;j+gap<m;j++){
	             if(arr2[j]>arr2[gap+j]){
	                 int temp=arr2[j];
	                 arr2[j]=arr2[gap+j];
	                 arr2[gap+j]=temp;
	             }
	         }
	         }
	         
	     }
	     
	 }
	 // rearrange array
	 public static void rearrangeArray(int[] arr,int n){
	     int left=0;
	     int right=n-1;
	     while(left<=right){
	         System.out.print(arr[right]+" ");
	         if(left!=right)
	         System.out.print(arr[left]+" ");
	         left++;
	         right--;
	     }
	     
	 }
	// Equilibrium point
	public static int equilibiriumPoint(int[] arr){
	     int n=arr.length;
	     if(n==1){
	         return 1;
	     }
	     int rightsum=0,leftsum=0;
	     for(int i=1;i<n;i++){
	         rightsum+=arr[i];
	     }
	     for(int i=0,j=1;i<n-2;j++,i++){
	         rightsum=rightsum-arr[j];
	         leftsum+=arr[i];
	         if(rightsum==leftsum){
	             return i+2;
	         }
	         
	     }
	     return -1;
	 }
	//Given an array of positive integers. Your task is to find the leaders in the array.
	//Note: An element of array is leader if it is greater than or equal to all the elements to its right side.
	//Also, the rightmost element is always a leader. 
	public static void Leaders(int arr[]){
	     int n=arr.length;
	     int leader=arr[n-1];
	      Stack<Integer> s=new Stack<>();
	      s.push(leader);
	     for(int i=n-2;i>=0;i-- ){
	         if(arr[i]>=leader){
	             leader=arr[i];
	             s.push(leader);
	         }
	     }
	     StringBuilder sb=new StringBuilder();
	     while(!s.isEmpty()){
	         sb.append(s.pop()+" ");
	     }
	     System.out.println(sb);
	 }
	//
	public static int minPlatform(int arr1[],int arr2[]){
	     Arrays.sort(arr1);
	     Arrays.sort(arr2);
	     int platform=0,res=0;
	     int i=0,j=0;
	     while(i<arr1.length && j<arr2.length){
	         if(arr1[i]<=arr2[j]){
	             platform++;
	             i++;
	             if(res<platform){
	                 res=platform;
	             }
	         }else{
	             platform--;
	             j++;
	             if(res<platform){
	                 res=platform;
	             }
	         }
	     }
	     return res;
	 }
	// stock buy and sell
	public static void stockBuySell(int price[]){
	     int n=price.length;
	     int i=0;
	     ArrayList<Index> ans=new ArrayList<>();
	     while(i<n-1){
	         
	         while(i<n-1 && price[i+1]<=price[i]){
	             i++;
	         }
	         if(i==n-1){
	             break;
	         }
	         Index idx=new Index();
	         idx.buy=i;
	         i++;
	         
	         while(i<n && price[i-1]<=price[i]){
	             i++;
	         }
	         idx.sell=i-1;
	         ans.add(idx);
	         
	     }
	     if(ans.size()==0){
	         System.out.println("No Profit");
	     }else{
	         for(Index j:ans){
	             System.out.print("("+j.buy+" "+j.sell+") ");
	         }
	         System.out.println();
	     }
	     
	 }
}
class Index{
	     int buy;
	     int sell;
	 }
