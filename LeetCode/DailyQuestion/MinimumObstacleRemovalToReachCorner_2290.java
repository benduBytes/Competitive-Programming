package DailyQuestion;
import java.util.*;

//Time Complexity: O(m * n log(m * n))
//Space Complexity: O(m * n)

public class MinimumObstacleRemovalToReachCorner_2290 {
    private static final int[] d = {0, 1, 0, -1, 0};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] di : dist) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{dist[0][0], 0,  0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int o = cur[0], r = cur[1], c = cur[2];
            if (r == m - 1 && c == n - 1) {
                return o;
            }
            for (int k = 0; k < 4; ++k) {
                int i = r + d[k], j = c + d[k + 1];
                if (0 <= i && i < m && 0 <= j && j < n && o + grid[i][j] < dist[i][j]) {
                    dist[i][j] = o + grid[i][j];
                    pq.offer(new int[]{dist[i][j], i, j});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
/*
Example 1:
Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
Output: 2
Explanation: We can remove the obstacles at (0, 1) and (0, 2) to create a path from (0, 0) to (2, 2).
It can be shown that we need to remove at least 2 obstacles, so we return 2.
Note that there may be other ways to remove 2 obstacles to create a path.

Example 2:
Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
Output: 0
Explanation: We can move from (0, 0) to (2, 4) without removing any obstacles, so we return 0.
*/