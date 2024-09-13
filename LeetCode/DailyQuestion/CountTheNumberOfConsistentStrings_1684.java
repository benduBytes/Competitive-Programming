package DailyQuestion;

//Time Complexity: O(N∗M)

public class CountTheNumberOfConsistentStrings_1684 {
	public int countConsistentStrings(String allowed, String[] words) {
		int count = words.length;
		int[] store = new int[26];

		for (char c : allowed.toCharArray()){
			store[c-'a']++;
		}

		for (String word : words) {
			
			for (char c : word.toCharArray()) {
				if (store[c-'a'] <= 0){
					count--;
					break;
				}
			}
		}
		return count;
	}
}

/*
Example 1:
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

Example 3:
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]

Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
*/
