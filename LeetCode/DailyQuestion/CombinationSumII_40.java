package DailyQuestion;
import java.util.*;

//Time Complexity : O(2^N)

public class CombinationSumII_40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList)); // Add a deep copy of tempList to the result
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
            if (candidates[i] > target) break;
            tempList.add(candidates[i]);
            backtrack(result, tempList, candidates, target - candidates[i], i + 1);
            tempList.remove(tempList.size() - 1); // Remove last element to backtrack
        }
    }
}

/*
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
*/