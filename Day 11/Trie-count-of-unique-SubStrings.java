
/*At university of Chicago a Computer Science programing faculty as a part of 
teaching passion, in order to make newly joined students more enthusiastic 
in learning the subject he is given a problem at the first day of semester.
The student who solved it first, will be awarded with a cash prize. In regard 
to this he asked the students to work on concept related to strings, he gave a 
task to read a word and find the count of all the turn of phrases of the word, 
and the phrases should be distinct.

Now it’s your time to create a method which satisfies the above program.
The turn of phrases of a word is obtained by deleting 
any number of characters (possibly zero) from the front of the word and
any number of characters (possibly zero) from the back of the word.

Input Format:
------------
A single string, the word contains only lowercase alphabets [a-z].

Output Format:
--------------
Print an integer, number of distinct phrases possible.


Sample Input-1:
---------------
aabbaba

Sample Output-1:
---------------- 
21

Explanation:
-------------
The turn of phrases of the word, which are distinct as follows:
a, b, aa, bb, ab, ba, aab, abb, bab, bba, aba, aabb, abba, bbab, baba, 
aabba, abbab, bbaba, aabbab, abbaba, aabbaba


Sample Input-2:
---------------
kmithyd

Sample Output-2:
----------------
28*/
import java.util.*;

class Trie {
    boolean end;
    Trie arr[];

    Trie() {
        end = false;
        arr = new Trie[26];
    }

    void insert(String s) {
        Trie curr = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.arr[c - 'a'] == null) {
                curr.arr[c - 'a'] = new Trie();
            }
            curr = curr.arr[c - 'a'];
        }
        curr.end = true;
    }
}

class first {
    public static int ans = 0;

    public static void count(Trie obj) {
        for (int i = 0; i < 26; i++) {
            if (obj.arr[i] != null) {
                if (obj.arr[i].end) {
                    ans++;
                }
                count(obj.arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Trie obj = new Trie();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                obj.insert(s.substring(i, j));
            }
        }
        count(obj);
        System.out.println(ans);
    }
}