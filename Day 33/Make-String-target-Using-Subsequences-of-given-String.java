
/*
Kiran is playing with strings and its subsequences.
A subsequence can be formed from a string by deleting some characters
(may be string itself)

Kiran has given two strings S and T, your task to form T by concatenating 
the subsequences of S  

Return the minimum number of subsequences required to form T.
If the task is impossible, return -1 .


Input Format:
-------------
Line-1 -> Two strings S and T

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
abc abcbc

Sample Output-1:
----------------
2

Explanation: 
------------
T = "abcbc" can be formed by "abc" and "bc",
which are subsequences of S = "abc".


Sample Input-2:
---------------
abc acdbc

Sample Output-2:
----------------
-1

Explanation: 
------------
string T cannot be constructed from the
subsequences of string S due to the character "d" in string T.*/
import java.util.*;

class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();
        int i = 0, j = 0, ans = 0;
        int flag = 1, match = 0;
        while (flag == 1) {
            if (j == t.length()) {
                if (i != 0)
                    ans++;
                System.out.println(ans);
                return;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                match = 1;
            } else {
                i++;
            }
            if (i == s.length()) {
                i = 0;
                ans++;
                if (match == 0)
                    flag = 0;
                match = 0;
            }

        }
        if (flag == 0)
            System.out.println("-1");
    }
}
