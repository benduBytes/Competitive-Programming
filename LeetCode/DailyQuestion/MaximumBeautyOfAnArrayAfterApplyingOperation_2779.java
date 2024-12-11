package DailyQuestion;
import java.util.*;

//Time Complexity: O(n + m)
//Space Complexity: O(m)

public class MaximumBeautyOfAnArrayAfterApplyingOperation_2779 {
	public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int maxValue = 0;

        // Step 1: Find the maximum value in the array
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        // Step 2: Create an array to track ranges
        int[] range = new int[maxValue + 10];

        // Step 3: Mark ranges for each number in the array
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, nums[i] - k);
            int right = Math.min(maxValue, nums[i] + k) + 1;
            range[left]++;
            range[right]--;
        }

        // Step 4: Calculate prefix sums and find the maximum value
        int result = range[0];
        for (int i = 1; i < range.length; i++) {
            range[i] += range[i - 1];
            if (range[i] > result) {
                result = range[i];
            }
        }

        // Step 5: Return the result
        return result;
    }
}
/*
Example 1:
Input: nums = [4,6,1,2], k = 2
Output: 3
Explanation: In this example, we apply the following operations:
- Choose index 1, replace it with 4 (from range [4,8]), nums = [4,4,1,2].
- Choose index 3, replace it with 4 (from range [0,4]), nums = [4,4,1,4].
After the applied operations, the beauty of the array nums is 3 (subsequence consisting of indices 0, 1, and 3).
It can be proven that 3 is the maximum possible length we can achieve.

Example 2:
Input: nums = [1,1,1,1], k = 10
Output: 4
Explanation: In this example we don't have to apply any operations.
The beauty of the array nums is 4 (whole array).
*/
