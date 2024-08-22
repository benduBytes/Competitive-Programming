package DailyQuestion;

//Time complexity: O(1)
public class NumberComplement_476 {
	/*
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder complement = new StringBuilder();

        for(char c : binary.toCharArray()){
            if(c == '0'){
                complement.append('1');
            }else{
                complement.append('0');
            }
        }
        return Integer.parseInt(complement.toString(),2);
    }
    */
    public int findComplement(int num) {
        if(num == 0) return 1;
        int binaryLength = Integer.toBinaryString(num).length();
        int mask = (1 << binaryLength) - 1;
        return num ^ mask;
    }
}

/*
Example 1:
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */