package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(N)

public class DeleteCharactersToMakeFancyString_1957 {
	public String makeFancyString(String s) {
        int counter=0; char prev='X';
        var sb = new StringBuilder();
        for (char c:s.toCharArray()){
            if (c==prev&&counter==2) continue;
            else if (c==prev&&counter<2){
                sb.append(c);
                counter++;
            } else if (c!=prev){
                sb.append(c);
                prev=c;
                counter=1;
            }
        }
        return sb.toString();
    }
}
/*
Example 1:
Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".

Example 2:
Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".

Example 3:
Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
*/