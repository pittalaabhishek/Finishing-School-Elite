
/*As the summer season is started, the people in Hyderbad will suffer due to
water crisis. To help the citizen of Hyderabad, GHMC planned to supply the 
water using water tanks. As a pilot project, GHMC selected R routes and 
covering L locations.

To serve a water tank request by the citizen, the tank has to take 
the planned routes by GHMC, Each Route[i] => ['src','des','amt'], start 
from a source 'src' to a destination 'des' and the amount to supply 
water'amt' between src and dest.
 
Now help the citizen of hyderabd to find a best route to order a water tank
with a best deal in such a way that, if you are given all the locations and 
routes information, combined with starting location as source ‘LOC1’ and 
the destination ‘LOC2’.

Your task is to find the best deal to supply the water tanks from source to 
destination with at most ‘H’ halts. If there is no desired route found to 
supply water tank, print -1.

NOTE: if there are L locations, the locations are indexed as: 0,1,2,..,L-1.

Input Format:
-------------
Line-1: Two integers L and R, L number of locations, and H halts.
Next L lines: 3 space separated integers, src, des,  amt per water tank. 
Next line: 3 space separated integers, LOC1, LOC2, S.

Output Format:
--------------
Print an integer, best deal to get a water tank.


Sample Input-1:
---------------
3 3
0 1 50
1 2 50
0 2 250
0 2 1

Sample Output-1:
----------------
100

Explnation:
-------------
source location is '0' and destination is '2', and no.of halts are 1.
Option-1 : you can start at location-0  to location-1, 1 halt at location-1
           and the start from location-1 to location-2, 
	       amount per water tank is 100
Option-2 : you can start at location-0  to location-2 directly, 
           amount per water tank is 250, So best deal is 100.


Sample Input-2:
---------------
3 3
0 1 50
1 2 50
0 2 250
0 2 0

Sample Output-2:
----------------
250

Explnation:
-------------
source location is '0' and destination is '2', and no halts.
So, you have to start at location-0  to location-2 directly, 
amount per water tank is 250. So best deal is 250.
*/
import java.util.*;

class second {
    static int func(int[][] arr, int curr, int des, int h, int[] vis) {
        if (curr == des)
            return 0;
        if (h < 0)
            return Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        vis[curr] = 1;
        for (int i = 0; i < arr.length; i++) {
            if (vis[i] == 0 && arr[curr][i] != 0) {
                int a = func(arr, i, des, h - 1, vis);
                if (a != Integer.MAX_VALUE)
                    a += arr[curr][i];
                ans = Math.min(ans, a);
            }
        }
        vis[curr] = 0;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(), r = sc.nextInt();
        int[][] arr = new int[l][l];
        for (int i = 0; i < r; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            arr[a][b] = c;
        }
        int s = sc.nextInt(), d = sc.nextInt(), h = sc.nextInt();
        int[] vis = new int[l];
        int ans = func(arr, s, d, h, vis);
        if (ans != Integer.MAX_VALUE)
            System.out.println(ans);
        else
            System.out.println(-1);
    }
}
