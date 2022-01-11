/*Mahalakshmi participated in a treasure-hunt conatins N boxes in it.
Each box is numbered from 0,1,2,3,...,N-1. 
All the boxes are intially locked with the passcodes, except Box-0.
The passcode is written in a envolope and marked with its concern box number.

Each box in the treasure hunt contains a list of envelopes, which has 
passcodes to open the other boxes. You can open the boxes in any order, 
but you have to start from box-0 intially.

The rule to win the treasure-hunt is to open all the boxes.
Your task is to find out, whether Mahalakshmi win the treasure hunt or not.
If she win, print "Win".
Otherwise, print "Lost"

Input Format:
-------------
Line-1: An integer, number of boxes.
Next N lines: space separated integers, box numbers.

Output Format:
--------------
Print a string value, Win or Lost


Sample Input-1:
---------------
5
1
2
3
4

Sample Output-1:
----------------
Win


Sample Input-2:
---------------
5
1
2
3
4

Sample Output-2:
----------------
Lost
*/

import java.util.*;

public class first {
    public static void func(int i, int[] vis, List<List<Integer>> list) {
        if (vis[i] == 1) {
            return;
        }
        vis[i] = 1;
        for (int j : list.get(i)) {
            func(j, vis, list);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("\\s+");
            List<Integer> curr = new ArrayList<>();
            for (String a : s) {
                curr.add(Integer.parseInt(a));
            }
            list.add(curr);
        }
        int[] vis = new int[n];
        func(0, vis, list);
        for (int i : vis) {
            if (i == 0) {
                System.out.println("Lost");
                return;
            }
        }
        System.out.println("Win");
    }
}