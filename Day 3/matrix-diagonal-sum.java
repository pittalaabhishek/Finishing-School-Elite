/*Given a board of size n*n, filled with numbers.

Your task is to find the total sum of the the diagonal-1 numbers and diagonal-2 numbers in the board.
consider the intersection value of the two diagonals(if any) only once in total sum.

Input Format:
-------------
Line-1 -> An integer N, size of square board.
Next N lines -> N space separated integers 

Output Format:
--------------
Print the diagonal sum.


Sample Input-1:
---------------
3
1 2 3
4 5 6
7 8 9

Sample Output-1:
----------------
25

Explanation: diagonal-1 + diagonal-2 (exclude intersection-5) = (1+5+9) + (3+7) = 25

Sample Input-2:
---------------
4
1 2 3 4
1 2 3 4
1 2 3 4
1 2 3 4

Sample Output-2:
----------------
20

Explanation: diagonal-1 + diagonal-2 (exclude intersection) = (1+2+3+4) + (4+3+2+1) = 20
*/
import java.util.*;
import java.io.*;

public class fourth{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            String s[]=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            arr[i][j]=Integer.parseInt(s[j]);
        }
        int sum=0,flag=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||i+j==n-1){
                    sum += arr[i][j];
                }
            }
        }
        bw.write(sum+"\n");
        bw.flush();
    }
}