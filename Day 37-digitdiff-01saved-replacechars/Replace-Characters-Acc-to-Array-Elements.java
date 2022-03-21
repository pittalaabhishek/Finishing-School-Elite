
/*
Somesh is given a task to you on Strings.
You have given a string S ([a-z]), and an integer array Arr[]
Now your task is to modify 'S' in such way:
replace the 'i+1' characters in the string, with next i-th character 
in alphabetic order(cyclic).

For example, if S="art", Arr[]=[2,3,5] is 3, 
i=0, modify('a') = 'c' , S="crt".
i=1, modify('c') = 'f', modify('r') = 'u', S="fut".
i=2, modify('f') = 'k', modify('u') = 'z', modify('t') = 'y', S="kzy"
Finally modified string is kzy. 

Note: if arr[i]=3 modify('z') ='c'

Return the final modified string after all such modifications to S are applied.

Input Format:
-------------
Line-1 -> A String S, length of S is L
Line-2 -> L space separated integers.

Output Format:
--------------
Print modifed String.


Sample Input-1:
---------------
adbp
1 2 3 4

Sample Output-1:
----------------
kmit
*/
import java.util.*;

class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        int n = arr.length;
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(str[i]);
        arr[n - 1] %= 26;
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Integer, Character> m2 = new HashMap<>();
        char c = 'a';
        for (int i = 0; i < 26; i++) {
            m1.put(c, i);
            m2.put(i, c);
            c++;
        }
        for (int i = n - 2; i >= 0; i--) {
            arr[i] = (arr[i + 1] + arr[i]) % 26;
        }
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int curr = m1.get(s.charAt(i)) + arr[i];
            ans = ans + m2.get(curr % 26);
        }
        System.out.println(ans);
    }
}
