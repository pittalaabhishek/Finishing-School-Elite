
/*Kohinoor diamond is robbed by Hrithik, He kept the diamond in a suitcase, 
the suitcase has a lock with 4 circular wheels, and each wheel consist of
0-9 digits in the order 0,1,2,3,4,5,6,7,8,9 only.
You can rotate a wheel from 0 to 9 or 9 to 0.

As the diamond is most valuable, the lock has some traps,
if anybody try to unlock the suitcase and reached any one of the traps,
the suitcase will be blasted. And you will be dead.

Initially, the suitcase lock is set to 0000.
and you will be given the unlock key, your task to find and print
the minimum number of rotations required to unlock the suitcase.
If it is not possible to unlock the suitcase without blasting, print -1.

NOTE:
In one rotation you can choose any one wheel and 
rotate to its next or previous digit.


Input Format:
-------------
Line-1: space separated strings, each string of length 4 and contains only digits [0-9]
Line-2: A string, key to unlock.

Output Format:
--------------
Print an integer, the minimum number of rotations required to unlock.


Sample Input-1:
---------------
0302 0202 0203 2323 3003
0303 

Sample Output-1:
----------------
8

Explanation:
------------
To unlock the suitcase the valid rotations are as follows:
0000 > 1000 > 1100 > 1200 > 1201 > 1202 > 1302 > 1303 > 0303.


Sample Input-2:
---------------
6656 6676 6766 6566 5666 7666 6665 6667
6666 

Sample Output-2:
----------------
-1

Explanation:
------------
You can't unlock the suitcase.
*/
import java.util.*;

class first {
    static int MiniMumSteps(String[] arr, String code) {
        ArrayDeque<String> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        String start = "0000";
        visited.add(start);
        q.offerLast(start);
        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);
        if (set.contains(code) || set.contains(start))
            return -1;
        int steps = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String temp = q.pollFirst();
                StringBuilder sb = new StringBuilder(temp);
                if (temp.equals(code)) {
                    return steps;
                }
                for (int j = 0; j < sb.length(); j++) {
                    char c = sb.charAt(j);
                    String s1 = sb.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(j + 1);
                    String s2 = sb.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(j + 1);
                    if (!set.contains(s1) && !visited.contains(s1)) {
                        visited.add(s1);
                        q.offerLast(s1);
                    }
                    if (!set.contains(s2) && !visited.contains(s2)) {
                        visited.add(s2);
                        q.offerLast(s2);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] trap = sc.nextLine().split(" ");
        String code = sc.nextLine();
        int ans = MiniMumSteps(trap, code);
        System.out.println(ans);
    }
}