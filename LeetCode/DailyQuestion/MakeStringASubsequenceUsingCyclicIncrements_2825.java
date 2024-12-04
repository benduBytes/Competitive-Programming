package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(1)

public class MakeStringASubsequenceUsingCyclicIncrements_2825 {
	 public boolean canMakeSubsequence(String source, String target) {
	        int srcLen = source.length();
	        int tgtLen = target.length();
	        int srcIdx = 0;
	        int tgtIdx = 0;
	        
	        while (srcIdx < srcLen && tgtIdx < tgtLen) {
	            char srcChar = source.charAt(srcIdx);
	            char tgtChar = target.charAt(tgtIdx);
	            
	            if (srcChar == tgtChar || 
	                (srcChar == 'z' && tgtChar == 'a') || 
	                (srcChar + 1 == tgtChar)) {
	                srcIdx++;
	                tgtIdx++;
	            } else {
	                srcIdx++;
	            }
	        }
	        return tgtIdx == tgtLen;
	    }	
}
/*
Example 1:
Input: str1 = "abc", str2 = "ad"
Output: true
Explanation: Select index 2 in str1.
Increment str1[2] to become 'd'. 
Hence, str1 becomes "abd" and str2 is now a subsequence. Therefore, true is returned.

Example 2:
Input: str1 = "zc", str2 = "ad"
Output: true
Explanation: Select indices 0 and 1 in str1. 
Increment str1[0] to become 'a'. 
Increment str1[1] to become 'd'. 
Hence, str1 becomes "ad" and str2 is now a subsequence. Therefore, true is returned.

Example 3:
Input: str1 = "ab", str2 = "d"
Output: false
Explanation: In this example, it can be shown that it is impossible to make str2 a subsequence of str1 using the operation at most once. 
Therefore, false is returned.
*/