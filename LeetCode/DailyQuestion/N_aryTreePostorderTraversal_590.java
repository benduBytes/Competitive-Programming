package DailyQuestion;
import java.util.*;

//Time Complexity : O(N)

//Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class N_aryTreePostorderTraversal_590 {
	public List<Integer> postorder(Node root) {
		// If the root is null, return an empty list
		if (root == null) return new ArrayList<>();
	
		List<Integer> res = new ArrayList<>();
	
		// Start DFS from the root
		dfs(root, res);
	
		// Return the result list containing node values in post-order
		return res;
	}
	
	private void dfs(Node root, List<Integer> res) {
		// Recursively call dfs for each child of the current node
		for (Node child : root.children) {
			dfs(child, res);
		}
		// Append the value of the current node to the result list
		res.add(root.val);
	}
}

/*
Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
*/ 