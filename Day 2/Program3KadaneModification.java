/*
You are playing a game. There are N boxes placed in a row (0-indexed), 
every box has some points. You need to play the game with the following rules:
 - Initially your score is  '0' points.
	- Suppose the box has p points in it.
	  if p>0 you will gain p points, if p<0 you will loose p points.
	- You are allowed to choose any number of consecutive boxes, atleast 1 box.
   	
You are given the points in the N boxes as points[]. 
Your target is to maximize your score by droping atmost one box in the set of 
consecutive boxes, and return the highest score possible. 

Note : The score should be considered for atleast 1 box even after droping a box.
 
Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, points[].
  
Output Format:
--------------
An integer, print the highest score.
    
Sample Input-1:
---------------
9
-3 1 -2 4 -2 2 3 -5 4
 
Sample Output-1:
----------------
 11
   
Explanation:
------------
By selecting consecutive boxes [4,-2,2,3,-5,4] and dropping -5 , has the highest
score is 11.
   
 
Sample Input-2:
---------------
 2
 1 -2
  
Sample Output-2:
----------------
1

Explanation:
------------
By picking the box is [1] has the highest score is 1.

*/
import java.util.*;
import java.io.*;

public class third{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        String[] s=br.readLine().split(" ");
        int[] arr=new int[s.length];
        for(int i=0;i<s.length;i++)arr[i]=Integer.parseInt(s[i]);
        int a1=0,a2=0;
        int[] f=new int[n];
        int[] b=new int[n];
        f[0]=arr[0];
        b[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            f[i]=Math.max(arr[i],arr[i]+f[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            b[i]=Math.max(arr[i],arr[i]+b[i+1]);
        }
        int ans=Integer.MIN_VALUE;
        int l=0,m=0;
        for(int i=0;i<n;i++){
            if(i!=0)l=f[i-1];
            if(i!=n-1)m=b[i+1];
            ans = Math.max(ans,l+m);
        }
        int temp=0,curr=0;
        for(int i=0;i<n;i++){
           curr += arr[i];
           if(curr>temp){
               temp=curr;
           }
           if(curr<0){
               curr=0;
           }
        }
        bw.write(Math.max(ans,temp)+"\n");
        bw.flush();
    }
}