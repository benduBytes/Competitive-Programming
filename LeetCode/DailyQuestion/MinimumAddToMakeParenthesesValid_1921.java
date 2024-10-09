package DailyQuestion;

//Time Complexity: O(N)
//Space Complexity: O(1)

public class MinimumAddToMakeParenthesesValid_1921 {
    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }
}
/*
Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3
*/