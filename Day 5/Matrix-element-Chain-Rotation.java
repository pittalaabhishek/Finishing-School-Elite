
/*
Rahul works in a Water purifying plant.His job is to pack the water bottles of 
different sizes in a box.He packed the water bottles in different boxes.Each box
may have different number of bottles and the count is printed on the box.

Rahul asked Suresh to send these bottles in a grid(0-indexed) where one box can
be placed in one cell.
grid[i][j] represents the count printed on the box placed on cell (i,j)

Given a shift value 's' , Suresh has to shift the boxes 's' times in the grid.

In one shift , he can move:
   -grid[i][j] to grid[i][j+1]
   -grid[i][q-1] to grid[i+1][0]
   -grid[p-1][q-1] to grid[0][0].
Return the 2D-grid after shifting.

Input Format:
 -------------
 Line -1: 3 space seperated integers p , q and s represents number of rows ,number of columns and number of shifts..
 next p-Lines: q Space separated integers represents count printed on the box. 

Output Format:
 --------------
 Print a 2D array, 
  
Sample Input -1:
-------------
3 3 2
2 3 4
5 6 7
8 9 10
    
Sample Output -1:
--------------
9 10 2 
3 4 5 
6 7 8 
    
Explanation:
 -----------
As s=2, Every value is shifted forward 2 times.
grid[0][0]=2 is shifted to grid[0][2], grid[0][1]=3 is shifted to grid[1][0] and so on...

  
Sample Input-2:
-------------
4 5 3
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
5 4 2 3 1
    
Sample Output-2:
--------------
2 3 1 1 2 
3 4 5 6 7 
8 9 10 11 12 
13 14 15 5 4 
    

*/
// Methods{
//     first : Printing Matrix elements as they are from calculated starting point
//     second : Putting in an array and performing array rotation and storing back values in matrix
// }
// Note:Buffered reader failed

import java.io.*;
import java.util.*;

public class first {
    /*
     * public static void Rotate(int[] arr,int s,int e){
     * int temp=arr[e];
     * for(int i=e;i>s;i--){
     * arr[i]=arr[i-1];
     * }
     * arr[s]=temp;
     * }
     */

    public static void main(String[] args) throws IOException {
        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
         * String s[]=br.readLine().split(" ");
         * int p=Integer.parseInt(s[0]);
         * int q=Integer.parseInt(s[1]);
         * int r=Integer.parseInt(s[2]);
         */
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        int l = 0;
        int[][] arr = new int[p][q];
        int[] mem = new int[p * q];
        /*
         * for(int i=0;i<p;i++){
         * String t[]=br.readLine().split(" ");
         * for(int j=0;j<q;j+=1){
         * arr[i][j]=Integer.parseInt(t[j]);
         * mem[l++]=arr[i][j];
         * }
         * }
         */
        // l=0;
        /*
         * for(int i=0;i<r;i++){
         * Rotate(mem,0,(p*q)-1);
         * }
         */
        /*
         * for(int i=0;i<p;i++){
         * for(int j=0;j<q;j+=1){
         * arr[i][j]=mem[l++];
         * }
         * }
         */
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j += 1) {
                arr[i][j] = sc.nextInt();
                mem[l++] = arr[i][j];
            }
        }
        int n = (p * q) - r, i = 0, flag = 0;
        while (n < (p * q)) {
            if (i % q == 0 && flag == 1) {
                bw.write("\n");
                bw.write(mem[n++] + " ");
            } else {
                bw.write(mem[n++] + " ");
                flag = 1;
            }
            i++;
        }
        n = 0;
        while (n < (p * q) - r) {
            if (i % q == 0 && flag == 1) {
                bw.write("\n");
                bw.write(mem[n++] + " ");
            } else {
                bw.write(mem[n++] + " ");
                flag = 1;
            }
            i++;
        }
        bw.flush();

    }
}
