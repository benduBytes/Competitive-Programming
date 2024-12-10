package DailyQuestion;
import java.util.*;

//Time Complexity: O(nlog n)
//Space Complexity: O(1)

public class FindLongestSpecialSubstringThatOccursThriceI_2981 {
	public int maximumLength(String s) {
        int n = s.length();
        int l = 1, r = n;

        if (!helper(s, n, l)) return -1;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (helper(s, n, mid)) l = mid;
            else r = mid;
        }

        return l;
    }

    private boolean helper(String s, int n, int x) {
        int[] cnt = new int[26];
        int p = 0;

        for (int i = 0; i < n; i++) {
            while (s.charAt(p) != s.charAt(i)) p++;
            if (i - p + 1 >= x) cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] > 2) return true;
        }

        return false;
    }
}
/*
Example 1:
Input: s = "aaaa"
Output: 2
Explanation: The longest special substring which occurs thrice is "aa": substrings "aaaa", "aaaa", and "aaaa".
It can be shown that the maximum length achievable is 2.

Example 2:
Input: s = "abcdef"
Output: -1
Explanation: There exists no special substring which occurs at least thrice. Hence return -1.

Example 3:
Input: s = "abcaba"
Output: 1
Explanation: The longest special substring which occurs thrice is "a": substrings "abcaba", "abcaba", and "abcaba".
It can be shown that the maximum length achievable is 1.
*/