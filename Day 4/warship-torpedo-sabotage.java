/*
There are some Warships, approaching the borders of India and curretly
situated in Bay of Bengal. One of the secret agent sent the picture of the warships.
 
The picture size is M * N, and he has marked each 1*1 part of the picture either 
with the Warships as 'W' or an empty place as 'E'. The Indian Navy want to destroy
those Warships using Torpedos, with one Torpedo you can destroy one Warship.

 The Warships are mentioned either horizontally or vertically in the picture. 
 And it is also mentioned that there are no adjacent warships.

Your target is find the number of Torpedos required to destroy all the Warships.

Input Format:
-------------
 Line-1: Two space separated integers M and N.
 Next M lines: N space separated characters, either W or E

Output Format:
--------------
Print an integer, number of torpedos required.
  
 Sample Input-1:
 ---------------
 2 3
 W E E
 W E E

Sample Output-1:
 ----------------
 1


 Sample Input-2:
---------------
 4 5
 W E E W W
 W E W E E
 W E W E W
 W E W E W
 
Sample Output-2:
----------------
 4

*/
import java.util.*;
import java.io.*;

public class second{
    public static int count=0;
    
    public static void func(int i,int j,char[][] arr,int[][] vis,int n,int m){
        if(i>=n||j>=m||arr[i][j]=='E'){
        return;
        }
        vis[i][j]=1;
        func(i+1,j,arr,vis,n,m);
        func(i,j+1,arr,vis,n,m);
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        char[][] arr=new char[n][m];
        for(int i=0;i<n;i++){
            String[] s1=br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j]=(s1[j].charAt(0));
            }
        }
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0&&arr[i][j]=='W'){
                    func(i+1,j,arr,vis,n,m);
                    vis[i][j]=0;
                    func(i,j+1,arr,vis,n,m);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}