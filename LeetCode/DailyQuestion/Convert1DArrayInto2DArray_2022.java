package DailyQuestion;

//Time Complexity: O(M*N)
public class Convert1DArrayInto2DArray_2022 {
	public int[][] construct2DArray(int[] original, int m, int n) {
        int arr[][]  = new int[m][n];

        int b = original.length;
        if(b != m*n){
            return new int[0][0];
        }

        int a = 0;
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = original[a];
                a++;
            }
        }
        return arr;
    }
}
/*
Example 1:
Input: original = [1,2,3,4], m = 2, n = 2
Output: [[1,2],[3,4]]
Explanation: The constructed 2D array should contain 2 rows and 2 columns.
The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.

Example 2:
Input: original = [1,2,3], m = 1, n = 3
Output: [[1,2,3]]
Explanation: The constructed 2D array should contain 1 row and 3 columns.
Put all three elements in original into the first row of the constructed 2D array.

Example 3:
Input: original = [1,2], m = 1, n = 1
Output: []
Explanation: There are 2 elements in original.
It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.
*/