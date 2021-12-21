/*KCR Chief Minister of Telangana Government has passed a new G.O to Telangana police for
safety of Telangana people. In this regard he announced new Vehicles to be released for all
the stations working for this mission especially.
Here we have a 2D mesh, there are P police officers and V vehicles, with P<=V.
Each police officer and vehicle is a 2D coordinate on this mesh.
Here the government has assigned a unique vehicle to each police officer.

Now create a method which prints the minimum possible sum of distances between each
police officer and their assigned vehicle.

Here the distance is between police officer Pi and vehicle Vi assigned to him.
And distance between Pi, Vi is calculated as follows: |Pi.x - Vi.x| + |Pi.y - Vi.y|


Input Format:
-------------
Line-1: Two integers P and V, number of police officers and vehicles.
Next P lines: Two space separated integers co-ordinates of Police officers.
Next V lines: Two space separated integers co-ordinates of Vehicles.

Output Format:
--------------
Print an integer, the minimum possible sum of distances.


Sample Input-1:
---------------
3 3
0 1		// co-ordinates of police
1 2
1 3
4 5		// co-ordinates of vehicles
2 5
3 6

Sample Output-1:
----------------
17


Sample Input-2:
---------------
2 2
0 0		// co-ordinates of police
2 1
1 2		// co-ordinates of vehicles
3 3

Sample Output-2:
----------------
6
*/

import java.util.*;

public class first {
    public static int ans = Integer.MAX_VALUE;

    public static void func(List<List<Integer>> l1, List<List<Integer>> l2, int index, int curr, int[] vis) {
        if (index == l1.size()) {
            if (curr < ans) {
                ans = curr;
            }
            return;
        }
        for (int i = 0; i < l2.size(); i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                curr = curr + Math.abs(l1.get(index).get(0) - l2.get(i).get(0))
                        + Math.abs(l1.get(index).get(1) - l2.get(i).get(1));
                func(l1, l2, index + 1, curr, vis);
                curr -= Math.abs(l1.get(index).get(0) - l2.get(i).get(0))
                        + Math.abs(l1.get(index).get(1) - l2.get(i).get(1));
                vis[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int v = sc.nextInt();
        List<List<Integer>> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list1.add(new ArrayList<>(Arrays.asList(a, b)));
        }
        for (int i = 0; i < v; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list2.add(new ArrayList<>(Arrays.asList(a, b)));
        }
        int[] vis = new int[v];
        func(list1, list2, 0, 0, vis);
        System.out.println(ans);
    }
}