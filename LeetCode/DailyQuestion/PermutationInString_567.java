package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(1)

public class PermutationInString_567 {
    public boolean checkInclusion(String s1, String s2) {
	    if(s1.length() > s2.length()) return false;
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(arr1, arr2)) return true;
        
        int front = 0;
        int back = s1.length();
        while(back < s2.length()){
            arr2[s2.charAt(front) - 'a']--;
            arr2[s2.charAt(back) - 'a']++;
            
            if(Arrays.equals(arr1, arr2)) return true;
            front++;
            back++;
        }
        return false;
    }
}
/*
Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
*/