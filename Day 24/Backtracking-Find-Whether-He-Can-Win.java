
/*
Ramesh and Suresh are best friends. 
They decided to play a word game.

The game rules are as follows:
	- The game board shows a word W consist of two characters only A and B.
	- You are allowed to replace a pair of neighbour letters AA with BB in W.
	- Finally, The one who failed to replace the letters will lose the game.

You can assume that Ramesh will start playing the game always.

Your task is to determine if Ramesh can guarantee a win.
Print 'true', if Ramesh guarantee a win, otherwise, print 'false'.

Input Format:
-------------
A string W, word.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
AAABAAAA

Sample Output-1:
----------------
true

Explanation:
------------
Given word is AAABAAAA 
Ramesh -> AAABBBAA 
Now whatever the pair Suresh replaced with BB, 
one more replace is possible for Ramesh
So, there is a guarantee for Ramesh to win.

Sample Input-2:
---------------
AAAAAA

Sample Output-2:
----------------
true


Sample Input-3:
---------------
AAABAAA

Sample Output-3:
----------------
false
*/
import java.util.*;

public class second {
    // static boolean func(StringBuilder sb,int f){
    // if(f==1&&!sb.toString().contains("AA")){
    // return false;
    // }
    // if(f==0&&!sb.toString().contains("AA")){
    // return true;
    // }
    // for(int i=0;i<sb.length()-1;i++){
    // if(sb.charAt(i)=='A'&&sb.charAt(i+1)=='A'){
    // sb.replace(i,i+2,"BB");
    // if(f==1){
    // if(func(sb,0))
    // return true;
    // }
    // else{
    // if(func(sb,1))
    // return true;
    // }
    // sb.replace(i,i+2,"AA");
    // }
    // }
    // return false;
    // }
    static boolean func(boolean[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!arr[i] && !arr[i + 1]) {
                arr[i] = !arr[i];
                arr[i + 1] = !arr[i + 1];
                boolean ans = !func(arr);
                arr[i] = !arr[i];
                arr[i + 1] = !arr[i + 1];
                if (ans)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // StringBuilder sb=new StringBuilder(s);
        // boolean ans=func(sb,1);
        boolean[] arr = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                arr[i] = !arr[i];
            }
        }
        boolean ans = func(arr);
        System.out.println(ans);
    }
}