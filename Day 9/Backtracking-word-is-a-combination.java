
/*Mr Shravan Kumar is given a word W and a list of words[]. He wants to check 
whether is it possible to create the word W from the given list of words 
by appending them or not. It is not necessary to use all the words from the list.
It is allowed to use the words in the list repeatedly if required to form the 
original W. 
Your task if to help Mr Nagireddy to find it is possibe to create the oridinal
word W or not. If possible print true. Otherwise flase.


Input Format:
-------------
Line-1: A single line word W, Original word.
Line-2: A single line space space-separated words, list[].

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
capable
cap cable ap able 

Sample Output-1:
----------------
true


Sample Input-2:
---------------
capable
cable ap able

Sample Output-2:
----------------
false
*/
import java.util.*;

public class first {
    public static boolean func(String word, String[] s, String curr) {
        if (curr.equals(word)) {
            return true;
        }
        if (curr.length() >= word.length()) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            String temp = curr;
            curr += s[i];
            if (func(word, s, curr))
                return true;
            curr = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String s[] = sc.nextLine().trim().split(" ");
        if (func(word, s, "")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}