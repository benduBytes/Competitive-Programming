package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(1)

public class CountTheNumberOfFairPairs_2563 {
	long countLess(int[] nums, int val) {
	    long res = 0;
	    for (int i = 0, j = nums.length - 1; i < j; ++i) {
	        while(i < j && nums[i] + nums[j] > val)
	            --j;
	        res += j - i;
	    }        
	    return res;        
	}
	public long countFairPairs(int[] nums, int lower, int upper) {
	    Arrays.sort(nums);
	    return countLess(nums, upper) - countLess(nums, lower - 1);
	}
}

/*
Example 1:
Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
Output: 6
Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).

Example 2:
Input: nums = [1,7,9,2,5], lower = 11, upper = 11
Output: 1
Explanation: There is a single fair pair: (2,3).
*/
