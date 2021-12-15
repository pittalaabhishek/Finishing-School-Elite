/*You are given a bunch of sticks with diffrent lengths.
All the even length sticks should be arranged to appear first in the bunch and 
all the odd length sticks should be arranged to appear first in the bunch.

Print the length of the sticks, after arranging them according to above conditions. 

Input Format:
-------------
Line-1: An integer N, number of sticks in the bunch
Line-2: N space separated integers, lengths of the sticks.

Output Format:
--------------
Print the list of length of the sticks after arrangements accordingly.


Sample Input-1:
---------------
4
1 4 3 2

Sample Output-1:
----------------
[4, 2, 1, 3]


Sample Input-2:
---------------
8
10 13 1 6 9 12 9 10

Sample Output-2:
----------------
[10, 6, 12, 10, 13, 1, 9, 9]
*/
import java.util.*;
import java.io.*;

public class third{
    public static void rotate(int[] arr,int s,int e){
        int even=arr[e];
        for(int i=e;i>s;i--){
            arr[i]=arr[i-1];
        }
        arr[s]=even;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        String s[]=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int i=0;
        while(i<n){
            if(arr[i]%2==1){    
                int j=i+1;
                while(j<n){
                    if(arr[j]%2==0){
                        rotate(arr,i,j);
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
        for(i=0;i<n;i++)
        bw.write(arr[i]+" ");
        bw.flush();
    }
}