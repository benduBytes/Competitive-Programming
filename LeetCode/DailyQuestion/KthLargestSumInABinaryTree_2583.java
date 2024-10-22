package DailyQuestion;
import java.util.*;
//Time Complexity: O(N)
//Space Complexity: O(N)


//Definition for a binary tree node.
class TreeNode9 {
    int val;
    TreeNode9 left;
    TreeNode9 right;
    TreeNode9() {}
    TreeNode9(int val) { this.val = val; }
    TreeNode9(int val, TreeNode9 left, TreeNode9 right) {
    this.val = val;
    this.left = left;
    this.right = right;
    }
}

public class KthLargestSumInABinaryTree_2583 {
	public long kthLargestLevelSum(TreeNode9 root, int k) {
        List<Long> res = new ArrayList<>();  // To store sum of each level
        Queue<TreeNode9> q = new LinkedList<>();  // Queue for level-order traversal
        q.add(root);  // Start BFS from the root node

        while (!q.isEmpty()) {
            int n = q.size();  // Number of nodes at the current level
            long sum = 0;  // Sum of node values at the current level
            
            for (int i = 0; i < n; i++) {
                TreeNode9 node = q.poll();
                sum += node.val;
                
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(sum);  // Store the sum of the current level
        }

        if (k > res.size()) return -1;
        
        res.sort(Collections.reverseOrder());  // Sort level sums in descending order
        
        return res.get(k - 1);  // Return the k-th largest sum
    }
}
/*
Example 1:
Input: root = [5,8,9,2,1,3,7,4,6], k = 2
Output: 13
Explanation: The level sums are the following:
- Level 1: 5.
- Level 2: 8 + 9 = 17.
- Level 3: 2 + 1 + 3 + 7 = 13.
- Level 4: 4 + 6 = 10.
The 2nd largest level sum is 13.

Example 2:
Input: root = [1,2,null,3], k = 1
Output: 3
Explanation: The largest level sum is 3.
*/