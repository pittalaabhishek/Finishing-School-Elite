/*JVS Infra Pvt Ltd purchased a flatland of size M*N, and it is divided into 1*1 cells.
They mave marked some cells with red colors indicated with 1.
and other cells with blue color indicated with 0.

They want build the walls in the form of rectangles by connecting four distinct 
red colored cells on the flatland that forms an axis-aligned rectangle.
And only the corners of the walls need to be red colored.

Your task is to help, JVS Infra to count the number of rectangular walls
can be built by connecting the red colored cells on the flatland.

Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, either 0 or 1 only.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
1 0 1 0
1 1 1 1
0 1 1 1

Sample Output-1:
----------------
4

Explanation:
-----------
Given flatland is:
1 0 1 0
1 1 1 1
0 1 1 1
Number of rectngular walls are: 4
rectangle-1: by connecting 1's at (0, 0), (1, 0), (0, 2), (1, 2)
rectangle-2: by connecting 1's at (1, 1), (1, 2), (2, 1), (2, 2)
rectangle-3: by connecting 1's at (1, 1), (1, 3), (2, 1), (2, 3)
rectangle-4: by connecting 1's at (1, 2), (2, 2), (1, 3), (2, 3)

txuj 
Sample Input-2:
---------------
4 5
1 0 1 0 1
0 0 0 1 0
0 1 1 0 1
1 0 1 0 0

Sample Output-2:
----------------
2*/

import java.util.*;

public class second {
    public static int combi(int n) {
        return factorial(n) / (factorial(2) * factorial(n - 2));
    }

    public static int factorial(int n) {
        int i, fact = 1;
        for (i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int func(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        StringBuilder sb;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                sb.append(arr[i][j]);
            }
            list.add(sb.toString());
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (func(list.get(i), list.get(j)) >= 2) {
                    ans += combi(func(list.get(i), list.get(j)));
                }
            }
        }
        System.out.println(ans);
    }
}
