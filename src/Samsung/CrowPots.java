package Samsung;
import java.io.*;



public class CrowPots {

	public static void main(String[] args) throws IOException{
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String[] str=br.readLine().split(" ");
//        int n=Integer.parseInt(str[0]);
//        int k=Integer.parseInt(str[1]);
//        int[] arr=new int[n];
//        str=br.readLine().split(" ");
//        for(int i=0;i<n;i++){
//            arr[i]=Integer.parseInt(str[i]);
//        }
		int n=2;
		int k=1;
		int arr[]= {58,5};
        mergeSort(arr,0,n-1);
       
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int sum=0;
        for(int i=0;i<k;i++) {
        	if(i==0) {
        		sum+=arr[i]*n;
        	}else {
        		sum+=(arr[i]-arr[i-1])*(n-i);
        	}
        }
        System.out.println(sum);


	}
	public static void mergeSort(int[] arr,int l,int r) {
		if(l<r) {
		int m=(l+r)/2;
		mergeSort(arr,l,m);
		mergeSort(arr,m+1,r);
		merge(arr,l,r);
		}
	}
	public static void merge(int [] arr,int l,int r) {
		int m=(l+r)/2;
		int n1=m-l+1;
		int n2=r-m;
		int []left=new int[n1];
		int []right=new int[n2];
		int k=l;
		for(int i=0;i<n1;i++) {
			left[i]=arr[k++];
		}
		for(int i=0;i<n2;i++) {
			right[i]=arr[k++];
		}
		int i=0,j=0;
		k=l;
		while(i<n1 && j<n2) {
			if(left[i]<=right[j]) {
				arr[k++]=left[i++];
			}else {
				arr[k++]=right[j++];
			}
		}
		while(i<n1) {
			arr[k++]=left[i++];
		}
		while(j<n2) {
			arr[k++]=right[j++];
		}
	}
	

}
