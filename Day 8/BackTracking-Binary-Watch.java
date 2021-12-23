
/*Bindu is passionated about clocks.
She found a digital clock, which has 2 rows of led lights,
Top row has 4-leds OOOO indicates hours (0-11).
Bottom row has 6-leds OOOOOO indicates minutes(0-59).
Where O -> led is OFF and * -> led is ON.

For Example: 
If the clock showing the led lights are as follows:
	OO*O indiactes a binary number, 0010 -> 2 hrs
	OO*O** indiactes a binary number, 001011 -> 11 minutes.
So, Time is 2:11

Now, you are given an integer N, number of led lights that are ON.
Your task is to find, all the  possible times in ascending order.

Format of time should be as follows:
	- Hours should not have leading 0's.
	- Minutes should be represented with 2 digits.

Suppose Current time is 1 hous 1 minute
	- Valid time is 1:01
	- Invalid time is as follows:- 01:1, 01:01, 1:1

Input Format:
-------------
An integer N, number of led lights ON.

Output Format:
--------------
Print the list of times in ascending order.


Sample Input:
---------------
1

Sample Output:
----------------
[0:01, 0:02, 0:04, 0:08, 0:16, 0:32, 1:00, 2:00, 4:00, 8:00]
*/

import java.util.*;

public class second {
    public static void func(int n, StringBuilder curr, List<String> list, int index) {
        if (n == 0) {
            if (Integer.parseInt(curr.substring(0, 4).toString(), 2) <= 11
                    && Integer.parseInt(curr.substring(4, 10).toString(), 2) <= 59) {
                if (Integer.parseInt(curr.substring(4, 10).toString(), 2) >= 10) {
                    if (!list.contains(Integer.parseInt(curr.substring(0, 4).toString(), 2) + ":"
                            + Integer.parseInt(curr.substring(4, 10).toString(), 2)))
                        list.add(Integer.parseInt(curr.substring(0, 4).toString(), 2) + ":"
                                + Integer.parseInt(curr.substring(4, 10).toString(), 2));
                } else {
                    if (!list.contains(Integer.parseInt(curr.substring(0, 4).toString(), 2) + ":0"
                            + Integer.parseInt(curr.substring(4, 10).toString(), 2))) {
                        list.add(Integer.parseInt(curr.substring(0, 4).toString(), 2) + ":0"
                                + Integer.parseInt(curr.substring(4, 10).toString(), 2));
                    }
                }
            }
            return;
        }
        for (int i = index; i < 10; i++) {
            curr.replace(i, i + 1, "1");
            func(n - 1, curr, list, i + 1);
            curr.replace(i, i + 1, "0");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> ans = new ArrayList<>();
        if (n >= 9) {
            System.out.println(ans);
            return;
        }
        StringBuilder sb = new StringBuilder("0000000000");
        func(n, sb, ans, 0);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
