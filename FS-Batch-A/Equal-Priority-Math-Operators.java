/*
Scoops an 2nd class boy is doing a maths assignment given by his teacher.
Scoops is very poor at maths. 

When given an expression he will evaluate the expression from the start to the end. 

Help Scoops to solve the problem. He assumes the +,-,*,/ has the equal priority. 

Sample Test Case - 1
input = 2+5*2
output = 14

Explanation - The expression when evaluated from start to end
we have 2+5 which is 7 and when 7 is multiplied with 2 we have 14 as the output 

Sample Test Case - 2
input = 2+3*6
output = 30

Explanation :- The sum of 2+3 is 5 and 5*6 = 30 

Sample Test Case - 3
input = 5+7-9+0*0+1
output = 1

Explanation :- The sum of 5+7 is 12 
12-9 is 3 and 3+0 is 3, 3*0 is 0 and 0+1 is 1 

Sample Test Case - 4
input = -1+-1*2
output = -4

Explanation :-
-1 + -1 is -2 
and -2 * 2 is -4
*/

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		char[] arr=new char[100];
		int[] brr=new int[100];
		int l1=0,l2=0,p=0;
		for(int i=1;i<s.length();i++){
		    char c=s.charAt(i);
		    if(c=='+'||c=='*'||c=='/'){
		        arr[l1++]=c;
		    }
		    else if(c=='-'){
		        int o=l1-1;
		        if(o>=0&&arr[o]=='-'){
		            continue;
		        }else if(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'){
		            arr[l1++]=c;
		        }
		    }
		}
		int i=0,flag=0;
		if(s.charAt(i)=='-'){
		    i++;
		    flag=1;
		}
		while(i<s.length()){
		    char c=s.charAt(i);
		    StringBuilder sb=new StringBuilder("");
		    if(c!='+'&&c!='-'&&c!='*'&&c!='/'){
		        int j=i;
		        while(j<s.length()&&s.charAt(j)!='+'&&s.charAt(j)!='-'&&s.charAt(j)!='*'&&s.charAt(j)!='/'){
		            sb.append(s.charAt(j));
		            j++;
		        }
		        if(sb.length()>0){
		            int n=Integer.parseInt(sb.toString());
		            if(flag==1)n*=(-1);
		            brr[l2++]=n;
		            flag=0;
		        }
		        i=j;
		    }else{
		        if(flag==0&&s.charAt(i)=='-'&&(s.charAt(i-1)=='+'||s.charAt(i-1)=='-'||s.charAt(i-1)=='*'||s.charAt(i-1)=='/'))
		        flag=1;
		        i++;
		    }
		}
		int res=brr[0];
		for(i=1;i<brr.length;i++){
		    if(arr[i-1]=='+'){
		        res += brr[i];
		    }else if(arr[i-1]=='-'){
		        res -= brr[i];
		    }else if(arr[i-1]=='*'){
		        res *= brr[i];
		    }else{
		        if(brr[i]==0)continue;
		        res /= brr[i];
		    }
		}
		/*System.out.println(l1-l2);
		for(int l=0;l<l1;l++)
		System.out.print(arr[l]+" ");
		System.out.println();
		for(int l=0;l<l2;l++)
		System.out.print(brr[l]+" ");
		System.out.println();*/
		System.out.print(res);
	}
}