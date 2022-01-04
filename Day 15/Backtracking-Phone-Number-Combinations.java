
/*Given a classic mobile phone, and the key pad of the phone looks like below.
	1		2		3
		   abc	   def
		 
	4		5		6
   ghi     jkl     mno
  
	7		8		9
  pqrs     tuv    wxyz
	
	*		0		#


You are given a string S contains digits between [2-9] only, 
For example: S = "2", then the possible words are "a", "b", "c".

Now your task is to find all possible words that the string S could represent.
and print them in a lexicographical order. 

Input Format:
-------------
A string S, consist of digits [2-9]

Output Format:
--------------
Print the list of words in lexicographical order.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[a, b, c]


Sample Input-2:
---------------
24

Sample Output-2:
----------------
[ag, ah, ai, bg, bh, bi, cg, ch, ci]
*/
import java.util.*;

public class third {
    public static Map<Character, String> map = new HashMap<>();
    public static List<String> list = new ArrayList<>();

    public static void func(String s, String curr, int n, int index) {
        if (curr.length() == s.length()) {
            list.add(curr);
            return;
        }
        if (index >= n)
            return;
        char c = s.charAt(index);
        for (int i = 0; i < map.get(c).length(); i++) {
            char a = map.get(c).charAt(i);
            func(s, curr + a, n, index + 1);
        }
    }

    public static void fill() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        fill();
        func(s, "", s.length(), 0);
        System.out.println(list);
    }
}