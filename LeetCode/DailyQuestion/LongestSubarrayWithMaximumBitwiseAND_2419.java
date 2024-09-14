package DailyQuestion;

//Time Complexity: O(n)
//Space Complexity: O(1)


public class LongestSubarrayWithMaximumBitwiseAND_2419 {
	public int longestSubarray(int[] nums) {
        int result = 0, length = 0, max = 0;
        for (int ele : nums) {
            max = Math.max(max, ele);
        }

        for (int ele : nums) {
            if (ele == max) {
                result = Math.max(result, ++length);
            } else length = 0;
        }
        return result;
    }
}


/*
Example 1:
Input: nums = [1,2,3,3,2,2]
Output: 2
Explanation:
The maximum possible bitwise AND of a subarray is 3.
The longest subarray with that value is [3,3], so we return 2.

Example 2:
Input: nums = [1,2,3,4]
Output: 1
Explanation:
The maximum possible bitwise AND of a subarray is 4.
The longest subarray with that value is [4], so we return 1.
*/