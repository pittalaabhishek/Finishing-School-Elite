
/*There are B bags containing N gold boxes each. In each bag, gold boxes are 
arranged  in ascending order of their weights strictly, create a method in 
such a way that we need to return the least weight of gold box which is 
common least weight in all the given bags.

If we don’t have any common least weighted gold box, among all the bags then return -1.

Input Format:
-------------
Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
Next B lines: N space separated integers, weights of GoldBoxes.

Output Format:
--------------
Print the least weight of gold box, if found
Print -1, if not found.


Sample Input:
---------------
5 5
1 2 3 4 5
2 3 6 7 9
1 2 3 5 8
1 3 4 6 8 
2 3 5 7 8

Sample Output:
----------------
3*/
import java.util.*;

public class third {
    public static boolean func(int[][] arr, int curr) {
        int count = 0;
        for (int k = 0; k < arr.length; k++) {
            int i = 0, j = arr[0].length - 1;
            while (i <= j) {
                int mid = (i + j) / 2;
                if (arr[k][mid] == curr) {
                    count++;
                    break;
                } else if (arr[k][mid] > curr) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            if (count == arr.length) {
                return true;
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
        int j = 0, ans = -1;
        for (int i = 0; i < m; i++) {
            int curr = arr[0][i];
            if (func(arr, curr)) {
                ans = curr;
                break;
            }
        }
        System.out.println(ans);
    }
}
