package DailyQuestion;
import java.util.*;

//Time Complexity: O(N^2)
//Space Complexity: O(1)

public class CheckIfNAndItsDoubleExist_1346 {
	public boolean checkIfExist(int[] arr) {
	    int n = arr.length;
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                if (i != j && arr[i] == 2 * arr[j]) 
                    return true;

        return false;
    }
}
/*
Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

Example 2:
Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
*/