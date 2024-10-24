package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(N)


//Definition for a binary tree node.
class TreeNode13 {
	int val;
  TreeNode13 left;
  TreeNode13 right;
  TreeNode13() {}
  TreeNode13(int val) { this.val = val; }
  TreeNode13(int val, TreeNode13 left, TreeNode13 right) {
  	this.val = val;
      this.left = left;
      this.right = right;
  }
}

public class FlipEquivalentBinaryTrees_951 {
    public boolean flipEquiv(TreeNode13 root1, TreeNode13 root2) {
        Queue<TreeNode13> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode13 n1 = q1.poll(), n2 = q2.poll();
            if (n1 == null || n2 == null) {
                if (n1 != n2) return false;
                else continue;
            }
            if (n1.val != n2.val) {
                return false;
            }
            if (n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val) {
                q1.addAll(Arrays.asList(n1.left, n1.right));
            }else {
                q1.addAll(Arrays.asList(n1.right, n1.left));
            }
            q2.addAll(Arrays.asList(n2.left, n2.right));
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
/*
Example 1:
Flipped Trees Diagram
Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.

Example 2:
Input: root1 = [], root2 = []
Output: true

Example 3:
Input: root1 = [], root2 = [1]
Output: false
*/