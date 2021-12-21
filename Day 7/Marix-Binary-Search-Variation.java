
/*There is a board with M*N size. 
The board contains M*N blocks of 1*1 size.
Each block is printed a number on it.

You will be given a number, your task is to find whether the number is printed on 
any of the blocks or not. If found print true, otherwise print false.

NOTE: 
- The numbers printed on the board in each row and each column are
  in increasing order. And all the numbers are unique.

Input Format:
-------------
Line-1 -> Two integers M and N, board size.
Next M lines -> N space separated integers.
Last Line -> An integer T, number to search.

Output Format:
--------------
Print a boolean value, 'true' if number found.
otherwise, 'false'.


Sample Input-1:
---------------
4 4
1 3 6 10
2 5 9 13
4 8 12 16
7 11 14 17
5

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4 4
1 3 6 10
2 5 9 13
4 8 12 16
7 11 14 17
15

Sample Output-2:
----------------
false
*/
import java.util.*;

// public static boolean search(int[][]arr,int n,int m,int t){
//     int i=0,j=m-1,k=0;
//     while(i<=j){
//         int mid=(i+j)/2;
//         if(arr[0][mid]==t){
//             return true;
//         }
//         if(arr[0][mid]>t){
//             i=mid+1;
//             k=i;
//         }
//         else{
//             j=mid-1;
//         }
//     }
//     i=0;
//     j=n-1;
//     k--;
//     while(i<=j){
//         int mid=(i+j)/2;
//         if(arr[mid][k]==t){
//             return true;
//         }
//         if(arr[mid][k]>t){
//             i=mid+1;
//         }
//         else{
//             j=mid-1;
//         }
//     }
//     return false;
// }
public class first {
    public static boolean search(int[][] arr, int n, int m, int t) {
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (t == arr[i][j]) {
                return true;
            } else if (t > arr[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int t = sc.nextInt();
        if (search(arr, n, m, t) == false) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

    }
}