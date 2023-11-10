package Samsung;

import java.util.Scanner;

public class FindPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
		 int t=sc.nextInt();
		 sc.nextLine();
		 while(t-->0){
		    String str=sc.nextLine();
		    char last=str.charAt(0);
		    int i=1;
		    int count=0;
		    while(i<str.length()){
		        if(str.charAt(i)=='0' && last=='1'){
		            while( i<str.length() && str.charAt(i)=='0'){
		                i++;
		            }
		            if( i<str.length() && str.charAt(i)=='1')
		            count++;
		        }
		        if(i<str.length())
		        last=str.charAt(i);
		        i++;
		        
		    }
		    System.out.println(count);
		 }

	}

}
