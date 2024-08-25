package DailyQuestion;
import java.util.*;


//Time Complexity : O(N)
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
	    this.val = val;
	    this.left = left;
	    this.right = right;
    }
}

public class BinaryTreePostorderTraversal_145 {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root != null) {
			 list.addAll(postorderTraversal(root.left));
			 list.addAll(postorderTraversal(root.right));
             list.add(root.val);
        }
        return list;
    }
}

/*
Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
*/ 