
/*Aziz is given a set of integers SOI[], consists of both +ve and -ve integers.

Aziz wants to find the maximum sum of contiguous subset of the SOI, with a twist.

You have to perform the following operation before finding the maximum sum:
- You are allowed to replace exactly one integer X, with its square value (X*X).

Can you please help Aziz to find out the maximum sum of contiguous subset.


Input Format:
-------------
Single line of space separated integers, values of the array.

Output Format:
--------------
Print an integer value as result.


Sample Input-1:
---------------
-5 -3 1 2 -3 4 -4 3

Sample Output-1:
----------------
26

Explanation:
------------
max sum is: (-5)^2 + (-3) + 1 + 2 + (-3) + 4 = 26


Sample Input-2:
---------------
2 -2 2 2 -2 -2 2

Sample Output-2:
----------------
10

Explanation:
------------
max sum is: 2 +(-2)^2 + 2 + 2 = 10
*/
import java.util.*;

public class second {
    static Map<String, Integer> map;

    public static int func(int n, int[] arr, int f) {
        if (n < 0)
            return 0;
        String key = n + "|" + f;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int ans = 0;
        if (f == 1) {
            ans = Math.max((arr[n] * arr[n]) + func(n - 1, arr, f - 1), (arr[n] * arr[n]));
        }
        ans = Math.max(ans, Math.max(arr[n] + func(n - 1, arr, f), arr[n]));
        map.put(key, ans);
        return map.get(key);
    }

    public static void main(String[] args) {
        map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] arr = new int[s.length];
        int n = 0;
        for (String i : s) {
            arr[n++] = Integer.parseInt(i);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, func(i, arr, 1));
        }
        System.out.println(ans);
    }
}