
/*Mallika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of numbers, and asked the students 
to find the sum of numbers between indices S1 and S2 (S1<=S2),
both S1 and S2 inclusive.

There are P Students in the class, numbered from 1 to P. Each student is
given set of indices and that student has to find the sum of the numbers 
between the indices and print the result.

And return the answer in the same order of

Input Format:
-------------
Line-1: Two integers N and P, N is length of set of numbers.
		where 1<= N <= 1000
Line-2: N space separated integers, array set[]
Next P lines: Two integers S1 and S2, index positions 
		where 0 <= S1 <= S2 < N
		and 1<= set[i] <= 100000

Output Format:
--------------
Print the sum of numbers between indices(s1, s2) given to each student.


Sample Input-1:
---------------
8 2
115053 59099 681359 526248 123844 612168 920784 591204
2 6
1 5

Sample Output-1:
----------------
2864403
2002718
*/
import java.util.*;

public class first {
    public static int[] t;

    public static void build(int[] a, int tl, int tr, int v) {
        if (tl == tr) {
            t[v] = a[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(a, tl, tm, v * 2);
            build(a, tm + 1, tr, v * 2 + 1);
            t[v] = t[v * 2] + t[v * 2 + 1];
        }
    }

    public static int sum(int v, int l, int r, int tl, int tr) {
        if (l > r) {
            return 0;
        }
        if (l == tl && r == tr) {
            return t[v];
        }
        int tm = (tl + tr) / 2;
        return sum(v * 2, l, Math.min(tm, r), tl, tm) + sum(v * 2 + 1, Math.max(tm + 1, l), r, tm + 1, tr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] a = new int[n];
        t = new int[4 * n];
        int ans[] = new int[q];
        int k = 0;
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        build(a, 0, n - 1, 1);
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            ans[k++] = sum(1, l, r, 0, n - 1);
        }
        for (int i = 0; i < q; i++) {
            System.out.println(ans[i]);
        }
    }
}
