package LeetCode_Problemset;
import java.util.*;

//Time Complexity - O(N)
public class MinimumNumberOfPushesToTypeWord1_3014 {
	public int minimumPushes(String word) {
        int n = word.length();
        int sum =0, i =1;
        while(n > 0){
            if(n>=8){
                sum+= (8*i);
                n -= 8;
            }else{
                sum += (n*i);
                n = 0;
            }
            i++;
        }
        return sum;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		MinimumNumberOfPushesToTypeWord1_3014 m = new MinimumNumberOfPushesToTypeWord1_3014();
		System.out.println(m.minimumPushes(str)); 
	}
}
/*
Test Case 1 :
input:
abcde
output:
5

Test Case 2 :
input:
xycdefghij
output:
12
 
*/
