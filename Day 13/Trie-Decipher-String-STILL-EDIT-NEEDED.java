
/*Mr Suresh is working with the plain text P, a list of words w[], 
He is converting P into C [the cipher text], C is valid cipher of P, 
if the following rules are followed:
	- The cipher-text C is a string ends with '$' character.
	- Every word, w[i] in w[], should be a substring of C, and 
	the substring should have $ at the end of it.

Your task is to help Mr Suresh to find the shortest Cipher C,  
and return its length.

Input Format:
-------------
Single line of space separated words, w[].

Output Format:
--------------
Print an integer result, the length of the shortest cipher.


Sample Input-1:
---------------
kmit it ngit

Sample Output-1:
----------------
10

Explanation:
------------
A valid cipher C is "kmit$ngit$".
w[0] = "kmit", the substring of C, and the '$' is the end character after "kmit"
w[1] = "it", the substring of C, and the '$' is the end character after "it"
w[2] = "ngit", the substring of C, and the '$' is the end character after "ngit"


Sample Input-2:
---------------
ace

Sample Output-2:
----------------
4

Explanation:
------------
A valid cipher C is "ace$".
w[0] = "ace", the substring of C, and the '$' is the end character after "ace"
*/
import java.util.*;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        int i = 0, j = 0;
        List<String> temp = new ArrayList<>();
        for (i = 0; i < list.size(); i++) {
            j = 0;
            while (j < list.size()) {
                if (i == j) {
                    j++;
                } else if (list.get(i).contains(list.get(j))) {
                    String curr = list.get(i);
                    String check = list.get(j);
                    if (curr.length() - curr.lastIndexOf(check) == check.length()) {
                        list.remove(check);
                    } else {
                        j++;
                    }
                } else {
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append("$");
        }
        System.out.println(sb.length());
    }
}
