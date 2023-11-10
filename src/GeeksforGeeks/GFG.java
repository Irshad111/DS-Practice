package GeeksforGeeks;


	/*package whatever //do not write package name here */

	import java.util.*;

	class GFG {
		public static void main (String[] args) {
		//	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//	int t=Integer.parseInt(br.readLine());
			
			Scanner sc=new Scanner(System.in);
			//int t=sc.nextInt();
			    int n=sc.nextInt(); //Integer.parseInt(br.readLine());
			    int arr[]=new int[n];
			   // String l=br.readLine();
			   // String[] str=l.split("//s");
			    for(int i=0;i<n;i++)
			    arr[i]=sc.nextInt();//Integer.parseInt(str[i]);
			    int []table=new int[n];
			    int len;
			    table[0]=arr[0];
			    len=1;
			    for(int i=1;i<n;i++){
			        if(arr[i]<table[0]){
			            table[0]=arr[i];
			        }else if(arr[i]>table[len-1]){
			            table[len]=arr[i];
			            len++;
			        }else{
			            int idx=search(table,0,len-1,arr[i]);
			            table[idx]=arr[i];
			        }
			    }
			    System.out.println(len);
			}
		
		public static int search(int a[],int l,int r,int key){
		    while(l<r){
		        int m=(l+r)/2;
		        if(a[m]>=key){
		            r=m;
		        }else{
		            l=m;
		        }
		    }
		    return r;
		}

}
