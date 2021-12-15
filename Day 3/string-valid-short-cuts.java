/*
The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d,a3,4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only lowercase
letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
*/
import java.util.*;
import java.io.*;

public class second{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String s1[]=br.readLine().split(" ");
        String s=s1[0];
        String t=s1[1];
        StringBuilder sb1=new StringBuilder(s);
        StringBuilder sb2=new StringBuilder(t);
        int flag=1,n=s.length(),count=0,m=t.length();
        StringBuilder temp=new StringBuilder("");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            if(sb2.charAt(i)<'a'){
                temp.append(sb2.charAt(i));
            }
            else if(temp.length()>0){
                int ans=Integer.valueOf(temp.toString());
                list.add(ans);
                temp=new StringBuilder("");
            }
        }
        int i=0,j=0,k=0;
        while(i<n&&j<m){
            if(sb1.charAt(i)==sb2.charAt(j)){
                i++;
                j++;
            }
            else{
                while(sb2.charAt(j)<'a'){
                    j++;
                }
                if(list.size()==0){
                    flag=0;
                    break;
                }else{
                    i+=list.remove(0);
                }
            }
        }
        if(flag==1&&j==m)
        System.out.println("true");
        else
        System.out.println("false");
    }
}