package DailyQuestion;
import java.util.*;

//Time Complexity - O(N)

public class MaximumDistanceInArrays_624 {
	public int maxDistance(List<List<Integer>> arrays) {
		int smallest = arrays.get(0).get(0);
	    int biggest = arrays.get(0).get(arrays.get(0).size() - 1);
	    int maxDistance = 0;

	    for (int i = 1; i < arrays.size(); i++) {
	    	maxDistance = Math.max(maxDistance, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - smallest));
	        maxDistance = Math.max(maxDistance, Math.abs(biggest - arrays.get(i).get(0)));
	        smallest = Math.min(smallest, arrays.get(i).get(0));
	        biggest = Math.max(biggest, arrays.get(i).get(arrays.get(i).size() - 1));
	    }
	    return maxDistance;
	 }	
}

/*
Example 1:
Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4
Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.

Example 2:
Input: arrays = [[1],[1]]
Output: 0
*/