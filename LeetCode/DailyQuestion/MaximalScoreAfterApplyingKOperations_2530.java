package DailyQuestion;
import java.util.*;

//Time Complexity: O(Nlogn+Klogn)
//Space Complexity: O(N)

public class MaximalScoreAfterApplyingKOperations_2530 {
	public long maxKelements(int[] arr, int k) {
        // Priorty Queue in reverse order is going to
        // give the highest number awailable
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        long answer = 0;

        // Add all the elements in priorty queue
        for(int i=0; i<n; i++){
            queue.add(arr[i]);
        }

        //Loop k number of times as mentioned in question
        for(int i=0; i<k; i++){

        //Now grab the element from queue by poll function
        // (it will give highest awailable always)
            int temp = queue.poll();
            answer += temp;

        // After adding highest element in our answer
        // Give that number back to queue by doing the-
        //-operation as told in question ceil(num[i]/3)
            double s = (double)temp/3;
            queue.add((int)Math.ceil(s));
        }
        return answer;
    }
}
/*
Example 1:
Input: nums = [10,10,10,10,10], k = 5
Output: 50
Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.

Example 2:
Input: nums = [1,10,3,3,3], k = 3
Output: 17
Explanation: You can do the following operations:
Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases by 3.
The final score is 10 + 4 + 3 = 17.
*/