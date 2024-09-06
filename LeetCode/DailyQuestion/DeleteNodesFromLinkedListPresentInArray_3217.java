package DailyQuestion;

//Time Complexity - O(n+m)
//Space Complexity - O(k)

//Definition for singly-linked list.
class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DeleteNodesFromLinkedListPresentInArray_3217 {
	public ListNode modifiedList(int[] nums, ListNode head) {
        int max = -1;
        for(int num : nums ){
            max = num > max ? num : max;
        }
        boolean[] freq = new boolean[max+1];

        for(int num : nums) freq[num] = true;

        ListNode temp = new ListNode();
        ListNode current = temp;

        while(head != null){
            if( head.val >= freq.length || freq[head.val] == false){
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }

        current.next = null;
        return temp.next;
    }
}

/*

Example 1:
Input: nums = [1,2,3], head = [1,2,3,4,5]
Output: [4,5]
Explanation:
Remove the nodes with values 1, 2, and 3.

Example 2:
Input: nums = [1], head = [1,2,1,2,1,2]
Output: [2,2,2]
Explanation:
Remove the nodes with value 1.

Example 3:
Input: nums = [5], head = [1,2,3,4]
Output: [1,2,3,4]
Explanation:
No node has value 5.

*/