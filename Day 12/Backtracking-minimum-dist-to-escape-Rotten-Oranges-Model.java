
/*Brahmi and his gang was chased by group of police officers,unfortunately they all got locked up in a building consist of M*N rooms in the form of a grid.All the rooms are connected with the adjacent rooms both horizontally and vertically.There are few rooms for them to escape called as safe zones.

Now help Brahmi and his gang to reach the safe zones in the building.

In the Building we have the rooms filled with following values:[0,-1,-2]where,-1->Danger zone(they should not enter into it).0->Safe Zone(room to escape)-2->a thief

Now create a method to print the grid after performing following step: 
Fill each room with one of the member from The Brahmi and his gang with 
the distance to its nearest safe zone.
If it is impossible to reach a safezone, fill with '-2' only.

Input Format:
-------------
Line-1 -> two integers M and N, size of the grid of rooms.
Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 4
-2 -1 0 -2
-2 -2 -2 -1
-2 -1 -2 -1
0 -1 -2 -2

Sample Output-1:
----------------
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4
*/
import java.util.*;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] vis = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0)
                    q.offerLast(new int[] { i, j });
                if (arr[i][j] == 0 || arr[i][j] == -1) {
                    vis[i][j] = 1;
                }
            }
        }
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int[] curr = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int k = curr[0] + dir[i][0];
                int l = curr[1] + dir[i][1];
                if ((k >= 0 && k < n) && (l >= 0 && l < m)) {
                    if (vis[k][l] == 0) {
                        vis[k][l] = 1;
                        arr[k][l] = arr[curr[0]][curr[1]] + 1;
                        q.offerLast(new int[] { k, l });
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}