package DailyQuestion;

//Time Complexity - O(n)
//Space Complexity - O(n)
public class FindMissingObservations_2028 {
	public int[] missingRolls(int[] rolls, int mean, int n) {
        
    	int i,m=rolls.length,sum=0;
    	for(i=0;i<m;i++)
    		sum+=rolls[i];
			
    	int x=(mean*(m+n))-sum;
		
		if(x<=0||n*6<x||((x/n)==0)) {
    		return new int[] {};
		}
			
    	int arr[]=new int[n];
    	
		int p=x/n,q=x%n;
    	for(i=0;i<n;i++)  {
		
    		arr[i]=p+(q>0?1:0);
    		q--;
    	}
    	return arr;
    }
}

/*
Example 1:
Input: rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.

Example 2:
Input: rolls = [1,5,6], mean = 3, n = 4
Output: [2,3,2,2]
Explanation: The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.

Example 3:
Input: rolls = [1,2,3,4], mean = 6, n = 4
Output: []
Explanation: It is impossible for the mean to be 6 no matter what the 4 missing rolls are.
*/