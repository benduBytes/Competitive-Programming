package DailyQuestion;
import java.util.*;

//Time Complexity: O(m * n log(m * n))
//Space Complexity: O(m * n)

public class MinimumTimeToVisitACellInAGrid_2577 {
	public int minimumTime(int[][] grid) {
	    if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
	    
	    int m = grid.length, n = grid[0].length;
	    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	    boolean[][] visited = new boolean[m][n];
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
	    pq.offer(new int[]{grid[0][0], 0, 0});
	    
	    while (!pq.isEmpty()) {
	        int[] curr = pq.poll();
	        int time = curr[0], row = curr[1], col = curr[2];
	        
	        if (row == m - 1 && col == n - 1) return time;
	        if (visited[row][col]) continue;
	        visited[row][col] = true;
	        
	        for (int[] dir : dirs) {
	            int r = row + dir[0], c = col + dir[1];
	            if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) continue;
	            int wait = ((grid[r][c] - time) % 2 == 0) ? 1 : 0;
	            pq.offer(new int[]{Math.max(grid[r][c] + wait, time + 1), r, c});
	        }
	    }
	    return -1;
	}
}
/*
Example 1:
Input: grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
Output: 7
Explanation: One of the paths that we can take is the following:
- at t = 0, we are on the cell (0,0).
- at t = 1, we move to the cell (0,1). It is possible because grid[0][1] <= 1.
- at t = 2, we move to the cell (1,1). It is possible because grid[1][1] <= 2.
- at t = 3, we move to the cell (1,2). It is possible because grid[1][2] <= 3.
- at t = 4, we move to the cell (1,1). It is possible because grid[1][1] <= 4.
- at t = 5, we move to the cell (1,2). It is possible because grid[1][2] <= 5.
- at t = 6, we move to the cell (1,3). It is possible because grid[1][3] <= 6.
- at t = 7, we move to the cell (2,3). It is possible because grid[2][3] <= 7.
The final time is 7. It can be shown that it is the minimum time possible.

Example 2:
Input: grid = [[0,2,4],[3,2,1],[1,0,4]]
Output: -1
Explanation: There is no path from the top left to the bottom-right cell.
*/