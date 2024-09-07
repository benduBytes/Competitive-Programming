package DailyQuestion;

//Time Complexity: O(n*m)
//Space Complexity: O(n)

//Definition for singly-linked list.
class ListNode1 {
 int val;
 ListNode1 next;
 ListNode1() {}
 ListNode1(int val) { this.val = val; }
 ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}


//Definition for a binary tree node.
class TreeNode1 {
 int val;
 TreeNode1 left;
 TreeNode1 right;
 TreeNode1() {}
 TreeNode1(int val) { this.val = val; }
 TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
 this.val = val;
 this.left = left;
 this.right = right;
 }
}
 

public class LinkedListInBinaryTree_1367 {
	public boolean isSubPath(ListNode1 head, TreeNode1 root) {
        return dfs(head, head, root);  // Start DFS search
    }

    // DFS helper function
    boolean dfs(ListNode1 head, ListNode1 cur, TreeNode1 root) {
        // If we reach the end of the linked list, return true (successful match)
        if (cur == null) return true;
        // If we reach the end of a path in the tree without fully matching the list, return false
        if (root == null) return false;
        
        // Match the current tree node with the current linked list node
        if (cur.val == root.val) cur = cur.next;
        // If no match, but the tree node matches the head of the linked list, start a new match
        else if (head.val == root.val) head = head.next;
        // Otherwise, reset `cur` to `head` to attempt matching the linked list from scratch
        else cur = head;

        // Continue DFS down both left and right children
        return dfs(head, cur, root.left) || dfs(head, cur, root.right);
    }
}


/*
Example 1:
Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.  

Example 2:
Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: true

Example 3:
Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
Output: false
Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.
*/