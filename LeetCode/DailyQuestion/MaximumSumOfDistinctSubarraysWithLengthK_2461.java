package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(N)

public class MaximumSumOfDistinctSubarraysWithLengthK_2461 {
	public long maximumSubarraySum(int[] A, int k) {
	    HashMap<Integer, Integer> mp = new HashMap<>();
	    long mx = 0, sum = 0;
	    for (int i = 0; i < A.length; i++){
	        sum +=A[i];
	        mp.put(A[i], mp.getOrDefault(A[i],0) + 1);

	        if (i >= k - 1){
	            if (mp.size() == k) mx = Math.max(mx, sum);
	            sum -= A[i - k + 1];
	            mp.put(A[i - k + 1], mp.get(A[i - k + 1]) - 1);
	            if (mp.get(A[i - k + 1]) == 0) mp.remove(A[i - k + 1]);
	        }
	    }
	    return mx;
	}
}
/*
Example 1:
Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

Example 2:
Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.
*/