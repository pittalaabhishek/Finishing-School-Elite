/*
Alice wants send a mail to his clients,
He has saved the clients Mail IDs in a list.
There exists an email parser, which perform the following checks 
and send the mail to the distinct clients, the checks are as follows:
- Each mail id has two parts, one is username one is domain name.
- The part before the @ symbol is username, and other is domain name.
- In username, if there exists a '.' symbol, remove it.
- In username, if there exists a '+' symbol, ignore the 
  suffix of the username from that symbol (including '+') 
- In domain name, the '.' symbol will be stays as it is.
- There will be no '+' symbol in domain name.

After performing above checks, your task is to find the count
of distinct client mail ids, who recieves the mail sent by Alice.

Input Format:
-------------
Space separated strings, emails list[].

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
a.v.nagireddy@kmit.in av.nagireddy@gmail.com avnagireddy@kmit.in a.v.nagireddy+org@kmit.in

Sample Output-1:
----------------
2

Explanation:
------------
These 3 mail id's: a.v.nagireddy@kmit.in, avnagireddy@kmit.in, a.v.nagireddy+org@kmit.in
are belons to same client with mail ID: avnagireddy@kmit.in
and another client with mail ID-av.nagireddy@gmail.com
So, there are 2 distinct clients.


Sample Input-2:
---------------
avnreddy@gmail.com avnreddy@yahoo.co.in nsudha@outlook.com

Sample Output-2:
----------------
3

Explanation:
------------
All 3 mail IDs belons to different clients.

*/

import java.util.*;

class Main {
    public static String func(String s) {
        StringBuilder sb = new StringBuilder();
        int f = 0, ff = 0;
        for (char c : s.toCharArray()) {
            if (c == '@')
                f = 1;
            if (f == 0 && c != '.') {
                if (c == '+')
                    ff = 1;
                if (ff == 0)
                    sb.append(c);
            } else if (f == 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String sarr[] = sc.nextLine().split(" ");
        Set<String> set = new HashSet<>();
        for (String s : sarr)
            set.add(func(s));
        System.out.println(set.size());
    }
}
