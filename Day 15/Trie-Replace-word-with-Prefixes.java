
/*In an english training institute, the trainer Reeta given a task to the trainees.
We know that, in english we have prefixes and suffixes for the words.
You can divide a word as concatenation of prefix and suffix.
i.e., word = prefix + suffix, another = an + other

You will be given a list of prefixes and a statement consisting of words.
Now, the task given to the trainees is as follows:
	- Replace all the words in the statement with the prefix, 
	  if you found prefix of that word in the list.
	- If you found more than one prefix in the list for a word in the statement,
	  replace the word with the prefix that has the shortest length.

Your task is to help the trainees to prepare and print the final statement
after all the replacements done.

Input Format:
-------------
Line-1: Space separated strings, prefixes.
Line-2: A single line of words, statement.

Output Format:
--------------
Print the String, the final statement.


Sample Input-1:
---------------
am add mean ref 
amigos used to address or refer to a friend

Sample Output-1:
----------------
am used to add or ref to a friend


Sample Input-2:
---------------
th the pa tho
thomas the trainer teaches theroy part of thermodynamics

Sample Output-2:
----------------
th th trainer teaches th pa of th
*/
import java.util.*;

class Trie {
    boolean isword;
    Trie[] characters;

    Trie() {
        isword = false;
        characters = new Trie[26];
    }

    void insert(String word, Trie trie) {
        Trie curr = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.characters[c - 'a'] == null) {
                curr.characters[c - 'a'] = new Trie();
            }
            curr = curr.characters[c - 'a'];
        }
        curr.isword = true;
    }

    String check(String word, Trie trie) {
        Trie curr = trie;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.characters[c - 'a'] == null) {
                return word;
            }
            sb.append(c);
            if (curr.characters[c - 'a'].isword) {
                return sb.toString();
            }
            curr = curr.characters[c - 'a'];
        }
        return sb.toString();
    }
}

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pre[] = sc.nextLine().trim().split(" ");
        String suf[] = sc.nextLine().trim().split(" ");
        Trie trie = new Trie();
        for (int i = 0; i < pre.length; i++) {
            trie.insert(pre[i], trie);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < suf.length; i++) {
            list.add(trie.check(suf[i], trie));
        }
        for (String i : list) {
            System.out.print(i + " ");
        }
    }
}