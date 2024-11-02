package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(1)

public class CircularSentence_2490 {
	public boolean isCircularSentence(String sentence) {
        // Get the length of the sentence
        int n = sentence.length();
        
        // First check: Compare first and last character of sentence
        // For a circular sentence, they must match
        if (sentence.charAt(0) != sentence.charAt(n-1)) return false;
        
        // Iterate through the sentence, starting from index 1 to n-2
        // We don't need to check first and last characters again
        for (int i = 1; i < n-1; i++) {
            // When we find a space character
            if (sentence.charAt(i) == ' ') {
                // Check if the character before space (last char of current word)
                // matches the character after space (first char of next word)
                if (sentence.charAt(i-1) != sentence.charAt(i+1)) return false;
            }
        }
        
        // If we made it through all checks, the sentence is circular
        return true;
    }
}
/*
Example 1:
Input: sentence = "leetcode exercises sound delightful"
Output: true
Explanation: The words in sentence are ["leetcode", "exercises", "sound", "delightful"].
- leetcode's last character is equal to exercises's first character.
- exercises's last character is equal to sound's first character.
- sound's last character is equal to delightful's first character.
- delightful's last character is equal to leetcode's first character.
The sentence is circular.

Example 2:
Input: sentence = "eetcode"
Output: true
Explanation: The words in sentence are ["eetcode"].
- eetcode's last character is equal to eetcode's first character.
The sentence is circular.

Example 3:
Input: sentence = "Leetcode is cool"
Output: false
Explanation: The words in sentence are ["Leetcode", "is", "cool"].
- Leetcode's last character is not equal to is's first character.
The sentence is not circular.
*/