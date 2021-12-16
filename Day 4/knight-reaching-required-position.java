/*
Mr Sudhakar is given a checkerboard of size 400*400, where the indices starts 
from (-200,-200) and ends at (199,199). In one step, he can move the box from 
position (p,q) to one of the following positions in L shape like as follows: 
	- (p-2, q-1), (p-2, q+1), (p+2, q-1), (p+2, q+1)
	- (p-1, q+2), (p+1, q+2), (p-1, q-2), (p+1, q-2)

Initially the box is at (0,0) position, and need to move the box to position (m,n).
You will be given two integers m and n indicates the position(m,n).

Now your task is to help by Mr Sudhakar to find the minimum number of steps 
required to move the box from (0,0) to (m,n).

Note: It is allowed to move out of the board also.

Input Format:
-----------------
Two space separated integers, m and n, position.

Output Format:
------------------
Print an integer, minimum number of steps to reach (m,n).


Sample Input-1:
---------------
2 4

Sample Output-1:
----------------
2

Explanation:
-------------
Initially, you are at (0,0) position, you can reach (2,4) as follows:
(0,0) -> (1, 2) -> (2, 4) 


Sample Input-2:
---------------
4 7

Sample Output-2:
----------------
5

Explanation:
------------
Initially, you are at (0,0) position, you can reach (4,7) as follows:
(0,0) -> (1, 2) -> (2, 4) -> (1, 6) -> (3, 5) -> (4, 7)
*/
import java.util.*;
import java.io.*;

//(p-2, q-1), (p-2, q+1), (p+2, q-1), (p+2, q+1)
//- (p-1, q+2), (p+1, q+2), (p-1, q-2), (p+1, q-2)
public class fifth{
    public static Map<String,Integer> map;
    
    public static int func(int[][] vis,int m,int n){
        /*if(m<0||n<0||m>=200||n>=200){
            return Integer.MAX_VALUE;
        }*/
        String key=m+"|"+n;
        if(map.containsKey(key))
        return map.get(key);
        if(m+n==2)return 2;
        else if(m+n==0) return 0;
        else{
        int a = 1+func(vis,Math.abs(m-1),Math.abs(n-2));
        int b = 1+func(vis,Math.abs(m-2),Math.abs(n-1));
        map.put(key,Math.min(a,b));
        }
        return map.get(key);
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        map=new HashMap<>();
        int m=Integer.parseInt(s[0]);
        int n=Integer.parseInt(s[1]);
        int[][] vis=new int[200][200];
        int ans=func(vis,Math.abs(m),Math.abs(n));
        System.out.println(ans);
    }
}