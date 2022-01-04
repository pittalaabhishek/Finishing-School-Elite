/*
A magic box with p rows and r columns is initially filled with silver.
If we invoke a method addMagicOperation which turns the silver at 
index(row, col) into gold. Given N set of indices to work up on, 
find the number of gold-blocks which are formed after each addMagicOperation. 

A gold-block is a block of gold cells connected horizontally and vertically 
and surrounded by silver. Consider all four edges of the magic box are 
surrounded by silver.

Input Format:
--------------
Line-1: Three space separated integers p, r , and n (number of add Magic Operations)
Next N lines: Two space separated integers, cell to perform addMagicOperation 

Output Format:
--------------
Print a list of numbers, number of gold-blocks formed after each addMagicOperation


Sample Input-1:
-----------------
3 3 5
0 0
0 1
1 2
2 1
1 1

Sample Output-1:
-----------------
[1, 1, 2, 3, 1]

Explanation:

Initially, the magic box is filled with silver. (Assume 0 represents silver and 1 represents gold).

0 0 0
0 0 0
0 0 0

Operation #1: addMagicOperation(0, 0) turns the silver at cell[0][0] into gold.

1 0 0
0 0 0   Number of Gold-blocks = 1
0 0 0

Operation #2: addMagicOperation(0, 1) turns the silver at cell[0][1] into gold.

1 1 0
0 0 0   Number of Gold-blocks = 1
0 0 0

Operation #3: addMagicOperation(1, 2) turns the silver at cell[1][2] into gold.

1 1 0
0 0 1   Number of Gold-blocks = 2
0 0 0

Operation #4: addMagicOperation(2, 1) turns the silver at cell[2][1] into gold.

1 1 0
0 0 1   Number of Gold-blocks = 3
0 1 0

Operation #5: addMagicOperation(1, 1) turns the silver at cell[1][1] into gold.

1 1 0
0 1 1   Number of Gold-blocks = 1
0 1 0

*/

import java.util.*;

class Main {
    public static int count = 0;

    public static int find(int x, int par[]) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x], par);
    }

    public static void union(int x, int y, int par[]) {
        x = find(x, par);
        y = find(y, par);
        if (x != y) {
            par[Math.max(x, y)] = Math.min(x, y);
            count--;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(), r = sc.nextInt(), t = sc.nextInt();
        int arr[][] = new int[p][r], par[] = new int[p * r];
        for (int i = 0; i < p; i++)
            for (int j = 0; j < r; j++)
                par[i * p + j] = i * p + j;
        List<Integer> res = new ArrayList<>();
        int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt(), n = sc.nextInt();
            arr[m][n] = 1;
            count++;
            for (int k = 0; k < 4; k++) {
                int x = m + dir[k][0], y = n + dir[k][1];
                if (x >= 0 && x < p && y >= 0 && y < r && arr[x][y] == 1) {
                    union(m * p + n, x * p + y, par);
                }
            }
            res.add(count);
        }
        System.out.println(res);
    }
}

// import java.util.*;

// class Main{
// public static void dfs(int m, int n, int i, int j, int arr[][], boolean
// vis[][]){
// int dir[][] = {{1, 0}, {0,1}, {-1, 0}, {0,-1}};
// for(int k=0; k<4; k++){
// int x = i+dir[k][0], y = j+dir[k][1];
// if(x>=0 && x<m && y>=0 && y<n && arr[x][y]==1 && !vis[x][y]){
// vis[x][y] = true;
// dfs(m, n, x, y, arr, vis);
// }
// }
// }

// public static int func(int m, int n, int arr[][], boolean vis[][]){
// int c = 0;
// for(int i=0; i<m; i++){
// for(int j=0; j<n; j++){
// if(arr[i][j]==1 && !vis[i][j]){
// dfs(m, n, i, j, arr, vis);
// c++;
// }
// }
// }
// return c;
// }

// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// int p = sc.nextInt(), r = sc.nextInt(), n = sc.nextInt();
// int arr[][] = new int[p][r];
// List<Integer> res = new ArrayList<>();
// for(int i=0; i<n; i++){
// int x = sc.nextInt(), y = sc.nextInt();
// arr[x][y] = 1;
// res.add(func(p, r, arr, new boolean[p][r]));
// }
// System.out.println(res);
// }
// }