package DailyQuestion;
import java.util.*;

//Time Complexity: O(N)
//Space Complexity: O(N)

public class UncommonWordsFromTwoSentences_884 {
	public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> str = new HashMap<>();

        int n1 = s1.length();
        String s11 = ""; 

        for (int i = 0; i < n1; i++) {
            if (s1.charAt(i) != ' ') { 
                s11 += s1.charAt(i);
            } else {
                str.put(s11, str.getOrDefault(s11, 0) + 1);
                s11 = "";
            }
        }

        if (!s11.isEmpty()) {
            str.put(s11, str.getOrDefault(s11, 0) + 1);
        }

        int n2 = s2.length();
        String s21 = ""; 

        for (int i = 0; i < n2; i++) {
            if (s2.charAt(i) != ' ') {
                s21 += s2.charAt(i);
            } else {
                str.put(s21, str.getOrDefault(s21, 0) + 1);
                s21 = "";
            }
        }
        if (!s21.isEmpty()) {
            str.put(s21, str.getOrDefault(s21, 0) + 1);
        }
        List<String> uncommonWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : str.entrySet()) {
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }

        return uncommonWords.toArray(new String[0]);
    }
}

/*
Example 1:
Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Explanation:
The word "sweet" appears only in s1, while the word "sour" appears only in s2.

Example 2:
Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
*/