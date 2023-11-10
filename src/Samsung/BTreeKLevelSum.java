package Samsung;

import java.util.Scanner;

public class BTreeKLevelSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 //code
		 Scanner sc=new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t-->0){
		     int k=sc.nextInt();
		     sc.nextLine();
		     String str=sc.nextLine();
		     int sum=0;
		     int idx=0;
		     int level=-1;
		     while(idx<str.length()){
		         char ch=str.charAt(idx);
		         if(ch=='('){
		             level++;
		             idx++;
		         }else if(ch==')'){
		             level--;
		             idx++;
		         }else if(ch>='0' && ch<='9'){
		            if(level==k){
		                int temp=0;
		                while(ch>='0' && ch<='9'){
		                    temp=temp*10+ch-'0';
		                    idx++;
		                    ch=str.charAt(idx);
		                }
		                sum+=temp;
		            }else{
		                idx++;
		            }
		         }
		     }
		     System.out.println(sum);
		     
		 }
		 

	}

}
