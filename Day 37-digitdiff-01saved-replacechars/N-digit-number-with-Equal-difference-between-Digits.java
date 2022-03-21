
/*Basava is interested in playing with digits.
He wants to create a set of integers of length N, using the digits[0-9].
The rules to create the integers are as follows:
	- digits in each integer are like d0,d1,d2...dn-1
	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

Basava is given two integers N and D, where N is length of the integer and 
D is the difference. Can you help Basava, to create such list of integers 
and print all the possible integers in ascending order


Note:
-----
Integers with leading 0's are not allowed


Input Format:
-------------
Two space separated integers N and K.

Output Format:
--------------
Print all the possible integers in ascending order.


Sample Input-1:
---------------
3 5

Sample Output-1:
----------------
[161, 272, 383, 494, 505, 616, 727, 838, 949]


Sample Input-2:
---------------
2 3

Sample Output-2:
----------------
[14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]
*/
import java.util.*;

class second {
    static int l;

    static void func(int n, int num, List<Integer> list, int d) {
        if (n == 1) {
            list.add(num);
            return;
        }
        if (n == 0)
            return;
        int a = num % 10 + d;
        int b = num % 10 - d;
        if (a < 10) {
            func(n - 1, num * 10 + a, list, d);
        }
        if (b != a && b >= 0 && b < 10) {
            func(n - 1, num * 10 + b, list, d);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        int d = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            func(l, i, list, d);
        }
        Collections.sort(list);
        System.out.println(list);
    }
}