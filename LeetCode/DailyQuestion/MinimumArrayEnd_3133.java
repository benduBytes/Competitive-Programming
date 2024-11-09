package DailyQuestion;

//Time Complexity: O(N)
//Space Complexity: O(1)

public class MinimumArrayEnd_3133 {
	public long minEnd(int n, int x) {
        long temp = x;
        for(int i = 1; i < n; i++) {
            temp = (x | (temp + 1));
        }
        return temp;
    }
}
/*
Example 1:
Input: n = 3, x = 4
Output: 6
Explanation:
nums can be [4,5,6] and its last element is 6.

Example 2:
Input: n = 2, x = 7
Output: 15
Explanation:
nums can be [7,15] and its last element is 15.
*/