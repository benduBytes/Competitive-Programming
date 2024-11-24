package DailyQuestion;
import java.util.*;

//Time Complexity: O(M∗N)
//Space Complexity: O(1)

public class MaximumMatrixSum_1975 {
	public long maxMatrixSum(int[][] matrix) {
        
    	int i,j,n=matrix.length,neg_nums=0,m=matrix[0].length,min=Integer.MAX_VALUE;
    	long ans=0;
    	for(i=0;i<n;i++)
    		for(j=0;j<m;j++) {
    			if(matrix[i][j]<0)
    				neg_nums++;
    			min=Math.min(min, Math.abs(matrix[i][j]));
    			ans+=Math.abs(matrix[i][j]);
    		}
    	if(neg_nums%2==0)
    		return ans;
    	return ans-min-min;
    	
    }
}
/*
Example 1:
Input: matrix = [[1,-1],[-1,1]]
Output: 4
Explanation: We can follow the following steps to reach sum equals 4:
- Multiply the 2 elements in the first row by -1.
- Multiply the 2 elements in the first column by -1.

Example 2:
Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
Explanation: We can follow the following step to reach sum equals 16:
- Multiply the 2 last elements in the second row by -1.
*/