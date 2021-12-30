
/*Clavius, the person who suggested grouping of data using brackets.
He has suggested that the grouping should be well formed.
Well formed groupings are as follows, (), [], {}, {()}, {[]()}, {[]}(), etc.

You will be given a string S, return true if the string S is a well formed 
grouping, otherwise false.

Note: S contains only characters ( ) [ ] { }

Input Format:
-------------
A string S, contains only characters (){}[]

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
{[([])[]]}

Sample Output-1:
----------------
true

Sample Input-2:
---------------
{[([])[]}]

Sample Output-2:
----------------
false
*/
import java.util.*;

class fourth {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stk = new Stack<>();
        String str = sc.next();
        int flag = 1;
        char p;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stk.push(c);
            else {
                if (c == ')') {
                    p = stk.pop();
                    if (p != '(') {
                        flag = 0;
                        break;
                    }
                }
                if (c == ']') {
                    p = stk.pop();
                    if (p != '[') {
                        flag = 0;
                        break;
                    }
                }
                if (c == '}') {
                    p = stk.pop();
                    if (p != '{') {
                        flag = 0;
                        break;
                    }
                }
            }
        }
        if (stk.isEmpty() == true && flag == 1)
            System.out.print("true");
        else
            System.out.print("false");
    }
}
