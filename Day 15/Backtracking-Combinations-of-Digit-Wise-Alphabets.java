
/*Alice has sent an encra cipher text to his friend Bob, and ask his help 
to crack it. The cipher text conatins digits only. 

Bob has cracked the pattern of decryption as follows:
1 maps to 'A',  2 maps to 'B',  3 maps to 'C', ... , 26 maps to 'Z'.

Now its Alice task is to find out the number of ways to decrypt 
the cipher text to plain text.

Example-1: 121 can be converted as ABA, or AU, or LA
Example-2: 1201 can be converted as ATA only. Alice is not allowed to 
convert as LA, 12 maps to L, 01 should not map to 'A'.


Input Format:
-------------
A string, the secret.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
123

Sample Output-1:
----------------
3

Explanation:
------------
123 can be converted as: ABC, LC, AW


Sample Input-2:
---------------
326

Sample Output-2:
----------------
2

Explanation:
------------
326 can be converted as: CBF, CZ*/
import java.util.*;

public class fourth {
    public static int func(String s, int i, int n, int[] dp) {
        if (i == n) {
            return 1;
        }
        if (i > n || s.charAt(i) == '0') {
            return 0;
        }
        if (dp[i] != -1)
            return dp[i];
        int ans;
        int num = Integer.parseInt(s.substring(i, Math.min(i + 2, s.length())));
        if (num <= 26) {
            return dp[i] = func(s, i + 1, n, dp) + func(s, i + 2, n, dp);
        }
        return dp[i] = func(s, i + 1, n, dp);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        int ans = func(s, 0, s.length(), dp);
        System.out.println(ans);
    }
}