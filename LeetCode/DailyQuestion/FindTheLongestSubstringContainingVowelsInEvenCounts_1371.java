package DailyQuestion;
import java.util.*;

//Time Complexity: O(n)
//Space Complexity: O(1)

public class FindTheLongestSubstringContainingVowelsInEvenCounts_1371 {
	public int findTheLongestSubstring(String s) {
        int[] mapy = new int[32];
        Arrays.fill(mapy, -2);
        mapy[0] = -1;

        int maxLen = 0;
        int mask = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case 'a':
                    mask ^= 1;
                    break;
                case 'e':
                    mask ^= 2;
                    break;
                case 'i':
                    mask ^= 4;
                    break;
                case 'o':
                    mask ^= 8;
                    break;
                case 'u':
                    mask ^= 16;
                    break;
            }

            int prev = mapy[mask];
            if (prev == -2) {
                mapy[mask] = i;
            } else {
                maxLen = Math.max(maxLen, i - prev);
            }
        }

        return maxLen;
    }
}

/*
Example 1:
Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.

Example 2:
Input: s = "leetcodeisgreat"
Output: 5
Explanation: The longest substring is "leetc" which contains two e's.

Example 3:
Input: s = "bcbcbc"
Output: 6
Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
*/