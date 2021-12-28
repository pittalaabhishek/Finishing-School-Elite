/*
Giridhar went to a bank to get 1-rupee coins for N rupees.
In the cash counter, there are unlimited CoinBags, 
each bag contains square number of coins (i.e, 1,4,9,16,...)

The clerk in the cash counter needs to provide the CoinBags,
Find the minimum number of CoinBags to give to Giridhar, whose total value equals N rupees.

Input Format:
-------------
An integer N.

Output Format:
--------------
Print an integer, minimum number of bags.


Sample Input-1:
---------------
13

Sample Output-1:
----------------
2

Explanation: 13 = 9 + 4

Sample Input-2:
---------------
21

Sample Output-2:
----------------
3

Explanation: 21 = 16+4+1.

*/

import java.util.*;

class Main {
    public static int func(int n) {
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i; j++) {
                if (i - (j * j) >= 0 && i - (j * j) <= n) {
                    dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(func(n));
    }
}