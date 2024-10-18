package DailyQuestion;

//Time Complexity: O(2^N)
//Space Complexity: O(N)

public class CountNumberOfMaximumBitwiseORSubsets_2044 {
	public void backtrack(int[] nums, int index, int currentOR, int maxOR, int[] count) {
        if (currentOR == maxOR) {
            count[0]++;
        }

        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, currentOR | nums[i], maxOR, count);
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;

        // Step 1: Compute the maximum OR
        for (int num : nums) {
            maxOR |= num;
        }

        int[] count = new int[1];
        // Step 2: Backtrack to count the subsets
        backtrack(nums, 0, 0, maxOR, count);

        return count[0];
    }
}
/*
Example 1:
Input: nums = [3,1]
Output: 2
Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
- [3]
- [3,1]

Example 2:
Input: nums = [2,2,2]
Output: 7
Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.

Example 3:
Input: nums = [3,2,1,5]
Output: 6
Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
- [3,5]
- [3,1,5]
- [3,2,5]
- [3,2,1,5]
- [2,5]
- [2,1,5]
*/