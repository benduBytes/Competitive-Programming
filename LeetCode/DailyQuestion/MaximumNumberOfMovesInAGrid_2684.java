package DailyQuestion;
import java.util.*;

//Time Complexity: O(M∗N)
//Space Complexity: O(M∗N)

public class MaximumNumberOfMovesInAGrid_2684 {
	int dirs[][] = {{0, 1}, {1, 1}, {-1, 1}}, m, n, cache[][];
    public int maxMoves(int[][] grid) {
        m = grid.length; n = grid[0].length; cache = new int[m][n];
        Arrays.stream(cache).forEach(row -> Arrays.fill(row, -1));

        int res = 0;
        for (int i = 0; i < m; i++)
            res = Math.max(res, dp(grid, i, 0));
        return res;
    }
    
    private int dp(int[][] grid, int i, int j) {
        if (cache[i][j] != -1) return cache[i][j];
        int ans = 0;
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < m && nj < n && grid[i][j] < grid[ni][nj])
                ans = Math.max(ans, 1 + dp(grid, ni, nj));
        }
        return cache[i][j] = ans;
    }
}
/*
Example 1:
Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.

Example 2:
Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
Output: 0
Explanation: Starting from any cell in the first column we cannot perform any moves.
*/