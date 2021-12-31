
/*Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, where two consecutive 
values in BCS having N bits, must have one bit difference only. 
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4
*/
import java.util.*;

public class third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList();
        list.add("0");
        list.add("1");
        for (int i = 1; i < n; i++) {
            List<String> temp = new ArrayList();
            temp.addAll(list);
            for (int j = 0; j < list.size(); j++) {
                String curr = "0" + list.get(j);
                list.set(j, curr);
            }
            for (int j = 0; j < list.size(); j++) {
                String curr = "1" + temp.get(j);
                temp.set(j, curr);
            }
            Collections.reverse(temp);
            list.addAll(temp);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = Integer.parseInt(list.get(i), 2);
            ans.add(num);
        }
        System.out.println(ans);
    }
}