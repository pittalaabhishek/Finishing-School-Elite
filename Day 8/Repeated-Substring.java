
/*You are given an alphanumeric word W.
You need find the number of words that can be formed from W.

The words have the following properties:
    - It should be a substring of W of any length, minimum 1.
    - All the letters in the word should be same.


Input Format:
-------------
Single String W.

Output Format:
--------------
Print an integer, the number of words can be formed


Sample Input-1:
---------------
daddy
 
Sample Output-1:
----------------
6

Explanation:
------------
The words are : d, a, d, d, dd, y


Sample Input-2:
---------------
binary11100

Sample Output-2:
----------------
15

Explanation:
------------
The words are : b, i, n, a, r, y, 1, 1, 1, 11, 11, 111, 0, 0, 00 
*/
import java.util.*;

public class third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = 0, count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                ans += (count * (count + 1)) / 2;
                count = 1;
            }
        }
        ans += count * (count + 1) / 2;
        System.out.println(ans);
    }
}
