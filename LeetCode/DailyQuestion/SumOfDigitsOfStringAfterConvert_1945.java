package DailyQuestion;

//Time complexity: O(K*N)
//Space complexity: O(N)

public class SumOfDigitsOfStringAfterConvert_1945 {
	public int getLucky(String s, int k) {
		StringBuilder number = new StringBuilder();
	    for(char x : s.toCharArray()){
	    	number.append(x - 'a' +1);
	    } 

	    while(k>0){
	    	int temp = 0;
	        for(char x : number.toString().toCharArray()){
	        	temp += x - '0';
	        }
	        number = new StringBuilder(String.valueOf(temp));
	        k--;
	    }
	    return Integer.parseInt(number.toString());
	}
}

/*
Example 1:
Input: s = "iiii", k = 1
Output: 36
Explanation: The operations are as follows:
- Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
- Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
Thus the resulting integer is 36.

Example 2:
Input: s = "leetcode", k = 2
Output: 6
Explanation: The operations are as follows:
- Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
- Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
- Transform #2: 33 ➝ 3 + 3 ➝ 6
Thus the resulting integer is 6.

Example 3:
Input: s = "zbax", k = 2
Output: 8
*/