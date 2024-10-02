package DailyQuestion;
import java.util.*;

//Time Complexity: O(NLogN)
//Space Complexity: O(N)

public class RankTransformOfAnArray_1331 {
	public int[] arrayRankTransform(int[] arr) {
        int[] A = Arrays.copyOf(arr, arr.length);
        Arrays.sort(A);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : A)
          rank.putIfAbsent(x, rank.size() + 1);
        for (int i = 0; i < arr.length; ++i)
          A[i] = rank.get(arr[i]);
        return A;
    }
}
/*
Example 1:
Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.

Example 2:
Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.

Example 3:
Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
*/