/*Aravind went to a forest, he stuck inside the forest and He is blind.
The forest is given as a square grid. The forest grid is filled with trees 
and empty cells. He can move upwards, downwadrs, left and right, 
but he cannot stop until he touches the tree. Once he touches a tree, 
he can choose the next direction to move. Intially Aravind is at poistion A, 
and he is trying to reach a safe-point at position S.

You will be given the forest grid filled with 1's and 0's, 1 means tree 
and 0 means empty cell. And initial position of Aravind, safe-point S.

Your task is to find the minimum distance travelled by Aravind to reach 
the safe-point, If he cannot stop at the safe-point, return -1.

You may assume that the borders of the forest are all trees.


Input Format:
-------------
Line-1: An integer N, size of the grid.
Next N lines: N space separated integers
Next line:  two space separated integers, initial position of Aravind
Next line:  two space separated integers, position of safe-point.

Output Format:
--------------
Print an integer, minimum distance travelled by Aravind to reah safe-point.


Sample Input-1:
---------------
5
0 1 0 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 0 1
0 0 0 0 0
2 4
4 0

Sample Output-1:
----------------
10

Explanation:
------------
For Picture look at hint.
The minimum path is : up -> left -> down -> left.

Sample Input-2:
---------------
5
0 1 0 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 0 1
0 0 0 0 0
0 3
3 3

Sample Output-2:
----------------
-1

Explanation: 
------------
Aravind cannot stop at safe-point.
*/
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        int[][] distance = new int[m][n];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(start);
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            for (int[] dir : dirs) {
                int nrow = p[0];
                int ncol = p[1];
                int count = 0;

                while (canRoll(maze, nrow + dir[0], ncol + dir[1])) {
                    nrow += dir[0];
                    ncol += dir[1];
                    count++;
                }

                // Update the distance[][], and use to check if a position is visited or not
                if (distance[p[0]][p[1]] + count < distance[nrow][ncol]) {
                    distance[nrow][ncol] = distance[p[0]][p[1]] + count;
                    queue.offer(new int[] { nrow, ncol });
                }

            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1
                : distance[destination[0]][destination[1]];
    }

    private boolean canRoll(int[][] maze, int nrow, int ncol) {
        int m = maze.length;
        int n = maze[0].length;
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && maze[nrow][ncol] == 0;
    }
}
