package DailyQuestion;
import java.util.*;

//05-08-2024

/*
2053. Kth Distinct String in an Array

Hint
A distinct string is a string that is present only once in an array.

Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.

 

Example 1:

Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1st, so it is the 1st distinct string.
"a" appears 2nd, so it is the 2nd distinct string.
Since k == 2, "a" is returned. 
Example 2:

Input: arr = ["aaa","aa","a"], k = 1
Output: "aaa"
Explanation:
All strings in arr are distinct, so the 1st string "aaa" is returned.
Example 3:

Input: arr = ["a","b","a"], k = 3
Output: ""
Explanation:
The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
*/

public class kthDistinct_2053 {
	
	//Time Complexity - O(N)
	public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        List<String> distinctStrings = new ArrayList<>();
        
        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                distinctStrings.add(s);
            }
        }
        
        if (distinctStrings.size() < k) {
            return "";
        }
        
        return distinctStrings.get(k - 1);
    }
	
	/*
	 //Time Complexity - O(N^2)
	 public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        List<String> distinctStrings = new ArrayList<>();
        
        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                distinctStrings.add(s);
            }
        }
        
        if (distinctStrings.size() < k) {
            return "";
        }
        
        return distinctStrings.get(k - 1);
    } 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String arr[] = new String[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.next();
		}
		sc.nextLine();
		int k = sc.nextInt();
		sc.close();
		
		System.out.println(kthDistinct(arr,k));
	}
}





/*
Test Case 1 :
input:
6
d b c b c a
2
output:
a

Test Case 2 :
input:
3
aaa aa a
3
output:
a
  
Test Case 3 :
input:
3
a b a
3
output:
""  
 */
