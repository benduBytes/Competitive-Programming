package DailyQuestion;

//Time complexity: O(N)
//Space complexity:O(K)


//Definition for singly-linked list.
class ListNode2 {
 int val;
 ListNode2 next;
 ListNode2() {}
 ListNode2(int val) { this.val = val; }
 ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}

public class SplitLinkedListInParts_725 {
	public ListNode2[] splitListToParts(ListNode2 root, int k) {
        // Create an array of ListNode pointers to store the k parts.
        ListNode2[] parts = new ListNode2[k];

        // Calculate the length of the linked list.
        int len = 0;
        ListNode2 node = root;
        while (node != null) {
            len++;
            node = node.next;
        }

        // Calculate the minimum guaranteed part size (n) and the number of extra nodes (r).
        int n = len / k, r = len % k;

        // Reset the pointer to the beginning of the linked list.
        node = root;
        ListNode2 prev = null;

        // Loop through each part.
        for (int i = 0; node != null && i < k; i++, r--) {
            // Store the current node as the start of the current part.
            parts[i] = node;

            // Traverse n + 1 nodes if there are remaining extra nodes (r > 0).
            // Otherwise, traverse only n nodes.
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }

            // Disconnect the current part from the rest of the list by setting prev.next to null.
            if (prev != null) {
                prev.next = null;
            }
        }

        // Return the array of k parts.
        return parts;
    }
}


/*
Example 1:
Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].

Example 2:
Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
*/