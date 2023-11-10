package Slidingwindow;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Window {
	public static void main(String[] arg) {
		int[] arr = { 1, 2, 2, 1, 1, 2 };
		// firstNegInteger(arr,2);
		countDistinct(arr, 3, 6);

	}

	// 1. find first -ve integer in k size sub array
	public static void firstNegInteger(int[] arr, int k) {
		Queue<Integer> q = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (i < k) {
			if (arr[i] < 0)
				q.add(i);
			i++;
		}
		for (; i < arr.length; i++) {
			if (!q.isEmpty()) {
				sb.append(arr[q.peek()] + " ");
			} else {
				sb.append("0 ");
			}
			while (!q.isEmpty() && k <= i - q.peek()) {
				q.remove();
			}
			if (arr[i] < 0) {
				q.add(i);
			}
		}
		if (!q.isEmpty()) {
			sb.append(arr[q.peek()] + " ");
		} else {
			sb.append("0 ");
		}
		System.out.println(sb);

	}

	// 2.Max Sum Subarray of size K
	public static int maxSum(int arr[], int k) {
		int n = arr.length;
		int sum = 0;
		int i = 0;
		while (i < k) {
			sum += arr[i];
			i++;
		}
		int max = sum;
		for (; i < n; i++) {
			sum += arr[i] - arr[i - k];
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	// 3. find maximum in every window of size k
	public static void maximum(int[] arr, int k) {
		Deque<Integer> q = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (i < k) {
			while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
				q.removeLast();
			}
			q.addLast(i);
			i++;
		}
		for (; i < arr.length; i++) {
			sb.append(arr[q.peek()] + " ");
			// if window size is greater than k then remove element
			while (!q.isEmpty() && k <= i - q.peek()) {
				q.removeFirst();
			}
			//
			while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
				q.removeLast();
			}
			q.addLast(i);

		}

		sb.append(arr[q.peek()] + " ");
		System.out.println(sb);

	}
	// 4. find distinct no in every window

	/* You are required to complete below method */
	/* You are required to complete below method */

	public static void countDistinct(int A[], int k, int n) {
		// Your code here
		if (k > n) {
			return;
		}
		HashMap<Integer, Integer> hs = new HashMap<>();
		int i;
		int distcount = 0;
		for (i = 0; i < k; i++) {
			if (!hs.containsKey(A[i])) {
				hs.put(A[i], 1);
				distcount++;
			} else {
				hs.put(A[i], hs.get(A[i]) + 1);
			}
		}
		System.out.print(distcount + " ");
		for (; i < n; i++) {

			if (hs.containsKey(A[i - k])) {
				if (hs.get(A[i - k]) == 1) {
					hs.remove(A[i - k]);
					distcount--;
				} else if (hs.get(A[i - k]) > 1) {
					int val = hs.get(A[i - k]);
					hs.put(A[i - k], val - 1);
				}
			}
			if (!hs.containsKey(A[i])) {
				hs.put(A[i], 1);
				distcount++;
			} else {
				hs.put(A[i], hs.get(A[i]) + 1);
			}
			System.out.print(distcount + " ");
		}

	}
	// 5. subarray with given sum
 public static void subArray(int[] arr,int k){
	     
         int i=0,flag=0;
         int sum=arr[i];
         int j=1;
	     while(j<=arr.length){
	         if(sum==k){
	             flag=1;
	             System.out.println(i+1+" "+j);
	             break;
	         }
	         if(sum<k && j<arr.length){
	             sum+=arr[j];
	             j++;
	         }
	         if(sum>k){
	             sum-=arr[i];
	             i++;
	         }
	     }
	     if(flag==0)
	     System.out.println("-1");
	         
	     
	 }
 // Second most repeated string in a sequence
 public static String secondRepeatedString(String[] str,int n){
     HashMap<String,Integer> hm=new HashMap<>();
     for(int i=0;i<str.length;i++){
         if(hm.containsKey(str[i])){
             hm.put(str[i],hm.get(str[i])+1);
         }else{
             hm.put(str[i],1);
         }
     }
     int max=0,smax=0;
     String res1="";
     String res2="";
     for(String key : hm.keySet()){
         if(max<hm.get(key)){
             smax=max;
             res2=res1;
             max=hm.get(key);
             res1=key;
         }else if(smax<hm.get(key) && max>hm.get(key)){
             smax=hm.get(key);
             res2=key;
         }
     }
     return res2;
 }

}
/*
 * Scanner sc=new Scanner(System.in); int t=sc.nextInt(); while(t-->0){ int
 * n=sc.nextInt(); int arr[]=new int[n]; for(int i=0;i<n;i++){
 * arr[i]=sc.nextInt(); } int k=sc.nextInt(); }
 * 
 * BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); int
 * t=Integer.parseInt(br.readLine()); while(t-->0){ int
 * n=Integer.parseInt(br.readLine()); int arr[]=new int[n]; String
 * line=br.readLine(); String str[]=line.split(" "); for(int i=0;i<n;i++){
 * arr[i]=Integer.parseInt(str[i]); } int k=Integer.parseInt(br.readLine());
 */
