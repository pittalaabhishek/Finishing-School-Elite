
/*Mounika is creating the binary strings using P 1's and Q 0's.
A binary string contains only 0's and 1's.
She has given a list of binary strings binStr[] to be formed.

Her task is to find, the maximum number of binary strings can be formed, 
with given P no.of 1's and Q no.of 0's only. She cannot use any more 1's or 0's.

Input Format:
-------------
Line-1 -> A single line of space separated binary strings, binStr[].
Line-2 -> Two integers P and Q, P number of 1's and Q number of 0's


Output Format:
--------------
Print an integer as output, maximum number of binary strings can be formed.


Sample Input-1:
---------------
10 0001 111001 1 0
3 5

Sample Output-1:
----------------
4

Explanation:
------------
She can form 4 strings by the using of 3 1's and 5 0's
strings are 10, 0001, 1, 0.


Sample Input-2:
---------------
10 1 0
1 1

Sample Output-2:
----------------
2

Explanation:
------------
She can form 2 strings by the using of 1 1's and 1 0's
strings are 1, 0.
*/
import java.util.*;

class first {
    static int arr[][];
    static Map<String, Integer> map = new HashMap<>();

    static int count0(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                count++;
        }
        return count;
    }

    static int count1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        return count;
    }

    static int func(int n, int m, String[] s, int index) {
        if (index == s.length) {
            return 0;
        }
        String key = n + "|" + m + "|" + index;
        if (map.containsKey(key))
            return map.get(key);
        int a1 = 0, a2 = 0;
        if (arr[index][0] <= m && arr[index][1] <= n)
            a1 = 1 + func(n - arr[index][1], m - arr[index][0], s, index + 1);
        a2 = func(n, m, s, index + 1);
        map.put(key, Math.max(a1, a2));
        return Math.max(a1, a2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = sc.nextInt(), m = sc.nextInt();
        arr = new int[s.length][2];
        for (int i = 0; i < s.length; i++) {
            arr[i][0] = count0(s[i]);
            arr[i][1] = count1(s[i]);
        }
        int ans = func(n, m, s, 0);
        System.out.println(ans);
    }
}