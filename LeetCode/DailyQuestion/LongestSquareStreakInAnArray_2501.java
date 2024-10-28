package DailyQuestion;
import java.util.*;

//Time Complexity: O(NLogN)
//Space Complexity: O(N)

public class LongestSquareStreakInAnArray_2501 {
	public int longestSquareStreak(int[] A) {
	    HashMap<Integer, Integer> dp = new HashMap<>();
	    int res = 0;
	    Arrays.sort(A);
	    for(var i : A){
	        int root = (int)Math.sqrt(i);
	        if(root * root == i)  
			   dp.put(i, dp.getOrDefault(root, 0) + 1);
	        else  
			   dp.put(i, 1);
	        res = Math.max(res, dp.get(i));
	    }
	    return res < 2 ? -1 : res;
	}
}
/*
Example 1:
Input: nums = [4,3,6,16,8,2]
Output: 3
Explanation: Choose the subsequence [4,16,2]. After sorting it, it becomes [2,4,16].
- 4 = 2 * 2.
- 16 = 4 * 4.
Therefore, [4,16,2] is a square streak.
It can be shown that every subsequence of length 4 is not a square streak.

Example 2:
Input: nums = [2,3,5,6,7]
Output: -1
Explanation: There is no square streak in nums so return -1.
*/