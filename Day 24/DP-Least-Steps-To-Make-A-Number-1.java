
/*Sampoornesh Babu is learning arithmatics.
His teacher given him a task to find the minimum number of operations
required to convert a given integer I to 1.

Sampoornesh is allowed to perform the following operations:
	- If I is even, convert I with I/2 .
	- In I is odd, convert I with either I+1 or I-1.

Now it's your task to help Sampoornesh Babu to find and print
the minimum number of operations required.

Input Format:
-------------
An integer I.

Output Format:
--------------
Print an integer, the minimum number of operations required.


Sample Input-1:
---------------
10

Sample Output-1:
----------------
4

Explanation:
------------
10 -> 5 -> 4-> 2 -> 1.


Sample Input-2:
---------------
15

Sample Output-2:
----------------
5

Explanation:
------------
15 -> 16 -> 8 -> 4 -> 2 -> 1.
*/
import java.util.*;

class first {
    static int func(int n) {
        if (n == 1) {
            return 0;
        }
        int a = Integer.MAX_VALUE;
        int p1 = a, p2 = a, p3 = a;
        if (n % 2 == 0) {
            p1 = func(n / 2);
        } else {
            p2 = func(n - 1);
            p3 = func(n + 1);
        }
        if (p1 != Integer.MAX_VALUE)
            p1++;
        if (p2 != Integer.MAX_VALUE)
            p2++;
        if (p3 != Integer.MAX_VALUE)
            p3++;
        return Math.min(p1, Math.min(p2, p3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = func(n);
        System.out.println(ans);
    }
}
