package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(N)


//Definition for a binary tree node.
class TreeNode10 {
	int val;
    TreeNode10 left;
    TreeNode10 right;
    TreeNode10() {}
    TreeNode10(int val) { this.val = val; }
    TreeNode10(int val, TreeNode10 left, TreeNode10 right) {
    	this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CousinsInBinaryTreeII_2641 {
	public TreeNode10 replaceValueInTree(TreeNode10 root) {
        dfs(new TreeNode10[] {root});
        root.val = 0;
        return root;
    }

    private void dfs(TreeNode10[] arr) {
        if (arr.length == 0) return;

        int sum = 0;
        for (TreeNode10 node : arr) {
            if (node == null) continue;
            if (node.left != null) sum += node.left.val;
            if (node.right != null) sum += node.right.val;
        }

        TreeNode10[] childArr = new TreeNode10[arr.length * 2];
        int index = 0;

        for (TreeNode10 node : arr) {
            int curSum = 0;
            if (node.left != null) curSum += node.left.val;
            if (node.right != null) curSum += node.right.val;

            if (node.left != null) {
                node.left.val = sum - curSum;
                childArr[index++] = node.left;
            }
            if (node.right != null) {
                node.right.val = sum - curSum;
                childArr[index++] = node.right;
            }
        }

        dfs(java.util.Arrays.copyOf(childArr, index));
    }
}
/*
Example 1:
Input: root = [5,4,9,1,10,null,7]
Output: [0,0,0,7,7,null,11]
Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
- Node with value 5 does not have any cousins so its sum is 0.
- Node with value 4 does not have any cousins so its sum is 0.
- Node with value 9 does not have any cousins so its sum is 0.
- Node with value 1 has a cousin with value 7 so its sum is 7.
- Node with value 10 has a cousin with value 7 so its sum is 7.
- Node with value 7 has cousins with values 1 and 10 so its sum is 11.

Example 2:
Input: root = [3,1,2]
Output: [0,0,0]
Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
- Node with value 3 does not have any cousins so its sum is 0.
- Node with value 1 does not have any cousins so its sum is 0.
- Node with value 2 does not have any cousins so its sum is 0.
*/
