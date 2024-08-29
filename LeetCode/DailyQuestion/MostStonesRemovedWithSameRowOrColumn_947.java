package DailyQuestion;
import java.util.*;

//Time Complexity: O(n^2)
//Space Complexity: O(n)

public class MostStonesRemovedWithSameRowOrColumn_947 {
	public int removeStones(int[][] stones) {
        int n = stones.length;
        if (n <= 1) {
            return 0;
        }

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int[] u = stones[i];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int[] v = stones[j];
                if (u[0] == v[0] || u[1] == v[1]) {
                    graph[i].add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            dfs(graph, visited, i);
            ans++;
        }

        return n - ans;
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited, int start) {

        visited[start] = true;

        List<Integer> neighbors = graph[start];
        for (int x : neighbors) {
            if (visited[x]) {
                continue;
            }

            dfs(graph, visited, x);
        }
    }
}

/*
Example 1:
Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.

Example 2:
Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.

Example 3:
Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
*/