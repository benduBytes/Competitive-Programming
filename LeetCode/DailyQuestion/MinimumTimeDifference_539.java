package DailyQuestion;
import java.util.*;

//Time Complexity: O(n)
//Space Complexity: O(n)

public class MinimumTimeDifference_539 {
	public int findMinDifference(List<String> timePoints) {
        // convert input to minutes
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }

        // sort times in ascending order
        Arrays.sort(minutes);

        // find minimum difference across adjacent elements
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        // consider difference between last and first element
        return Math.min(
            ans,
            24 * 60 - minutes[minutes.length - 1] + minutes[0]
        );
    }
}

/*
Example 1:
Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:
Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
*/