/*

M.P.Ahammed the founder of Malbar Gold and Diamonds merchant, announced an offer
that they will charge the minimum amount to make all the gold-biscuits into one.

Mr. Praveen, a gold supplier has different weighed gold-biscuits with him.
He wants to utilize the offer.

The processing charge to make two biscuits into one is calculated as follows:
	- To make two biscuits of weights A and B into one biscuit, 
	you have to pay the amount 'A + B'. 

Your task is to help M.P.Ahammed to keep his promise and 
to charge the minimum amount to make Mr. Praveen's gold-biscuits 
into one gold-biscuit.

Input Format:
-------------
Single line of space separated integers, number on the boxes.

Output Format:
--------------
Print an integer, minimum amount to be paid by Mr Shravan.


Sample Input-1:
---------------
4 3 6

Sample Output-1:
----------------
20


Sample Input-2:
---------------
5 2 4 3 6

Sample Output-2:
----------------
45


*/

import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String sarr[] = sc.nextLine().split(" ");
        int n = sarr.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            q.add(Integer.parseInt(sarr[i]));
        int res = 0;
        while (q.size() != 1) {
            int t = q.poll() + q.poll();
            q.add(t);
            res += t;
        }
        System.out.println(res);
    }
}

// import java.util.*;

// class Main{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// String sarr[] = sc.nextLine().split(" ");
// int n = sarr.length;
// List<Integer> arr = new ArrayList<>();
// for(int i=0; i<n; i++)
// arr.add(Integer.parseInt(sarr[i]));
// int res = 0;
// while(arr.size()!=1){
// Collections.sort(arr);
// int t = arr.get(0)+arr.get(1);
// arr.remove(0);
// arr.remove(0);
// arr.add(t);
// res+=t;
// }
// System.out.println(res);
// }
// }
