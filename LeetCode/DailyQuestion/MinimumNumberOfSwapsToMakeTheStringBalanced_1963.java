package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(N)

public class MinimumNumberOfSwapsToMakeTheStringBalanced_1963 {
	public int minSwaps (String s) {
        Stack <Character> stack = new Stack ();
        int mismatch = 0;
        for (int i = 0; i < s.length (); i++) {
            char ch = s.charAt (i);
            if (ch == '[')
                stack.push (ch);
            else {
                if (!stack.isEmpty ())
                    stack.pop ();
                else 
                    mismatch++;
            }
        }
        return (mismatch + 1) / 2;
    }
}
/*
Example 1:
Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".

Example 2:
Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".

Example 3:
Input: s = "[]"
Output: 0
Explanation: The string is already balanced.
*/