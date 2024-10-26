package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(N)

class TreeNode12 {
	int val;
    TreeNode12 left;
    TreeNode12 right;
    TreeNode12() {}
    TreeNode12(int val) { this.val = val; }
    TreeNode12(int val, TreeNode12 left, TreeNode12 right) {
    	this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class HeightOfBinaryTreeAfterSubtreeRemovalQueries_2458 {
	private Map<Integer, Integer> leftMap = new HashMap<>();
    private Map<Integer, Integer> rightMap = new HashMap<>();
    private Map<Integer, Integer> removed = new HashMap<>();
    
    public int[] treeQueries(TreeNode12 root, int[] queries) {
        populateHeights(root, 0);
        calculateRemovedHeights(root, 0);
        
        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            output[i] = removed.get(queries[i]);
        }
        return output;
    }
    
	// height is the max tree height with this node removed
    private void calculateRemovedHeights(TreeNode12 node, int height) {
        if (node == null) {
            return;
        }
        removed.put(node.val, height);
		
		// for each child, the height when removed is the max of the the height following
		// the opposite child, or the passed-in height with this node removed
        calculateRemovedHeights(node.left, Math.max(height, rightMap.get(node.val)));
        calculateRemovedHeights(node.right, Math.max(height, leftMap.get(node.val)));
    }
    
	// populate the maps with the total height of the left and right subtree of
	// each node, and return the larger of the two values
    private int populateHeights(TreeNode12 node, int height) {
        if (node == null) {
            return height - 1;
        }
        
        leftMap.put(node.val, populateHeights(node.left, height + 1));
        rightMap.put(node.val, populateHeights(node.right, height + 1));
        
        return Math.max(leftMap.get(node.val), rightMap.get(node.val));
    }
}
/*
Example 1:
Input: root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
Output: [2]
Explanation: The diagram above shows the tree after removing the subtree rooted at node with value 4.
The height of the tree is 2 (The path 1 -> 3 -> 2).

Example 2:
Input: root = [5,8,9,2,1,3,7,4,6], queries = [3,2,4,8]
Output: [3,2,3,2]
Explanation: We have the following queries:
- Removing the subtree rooted at node with value 3. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 4).
- Removing the subtree rooted at node with value 2. The height of the tree becomes 2 (The path 5 -> 8 -> 1).
- Removing the subtree rooted at node with value 4. The height of the tree becomes 3 (The path 5 -> 8 -> 2 -> 6).
- Removing the subtree rooted at node with value 8. The height of the tree becomes 2 (The path 5 -> 9 -> 3).
*/