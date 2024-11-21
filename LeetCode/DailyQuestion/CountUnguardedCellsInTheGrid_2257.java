package DailyQuestion;
import java.util.*;

//Time Complexity: O(M∗N)
//Space Complexity: O(M∗N)

public class CountUnguardedCellsInTheGrid_2257 {
	public int countUnguarded(int m, int n, int[][] guards, int[][] walls)
    {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        char[][] grid= new char[m][n];
        int count = m*n - guards.length - walls.length;
        for(int[] wall : walls)
        {
            int x = wall[0], y = wall[1];
            grid[x][y] = 'W';
        }
        for(int[] guard : guards)
        {
            int x = guard[0], y = guard[1];
            grid[x][y] = 'G';
        }
        for(int[] point : guards)
        {
            for(int dir[] : dirs)
            {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                while(!(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 'G' || grid[x][y] == 'W'))
                {
                    if(grid[x][y] != 'P')
                        count--;
                    grid[x][y] = 'P';
                    x += dir[0];
                    y += dir[1];
                }
            }
        }
        return count;
    }
}
/*
Example 1:
Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
Output: 7
Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
There are a total of 7 unguarded cells, so we return 7.

Example 2:
Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
Output: 4
Explanation: The unguarded cells are shown in green in the above diagram.
There are a total of 4 unguarded cells, so we return 4.
*/