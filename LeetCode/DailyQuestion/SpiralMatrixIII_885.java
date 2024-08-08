package DailyQuestion;
import java.util.*;

//TimeComplexity - O(R*C)
public class SpiralMatrixIII_885 {
	public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] matrix = new int[R*C][2];
        int i =0;
        matrix[i++] = new int[]{r0, c0};
        int len = 0;
        int d = 0;
        int[] direction = new int[]{0,1,0,-1,0};
        while(i<R*C){
            if(d == 0 || d == 2){
                len++;
            }
            for(int k =0;k<len;k++){
                r0 += direction[d];
                c0 += direction[d+1];

                if(r0 < R && r0 >= 0 && c0 < C && c0 >=0){
                    matrix[i++] = new int[]{r0,c0};
                }
            }
            d = ++d % 4;
        }
        return matrix;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int r0 = sc.nextInt();
		int c0 = sc.nextInt();
		
		int[][] result = spiralMatrixIII(R,C,r0,c0);
		for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
		
	}
}
/*
Test Case 1 :
Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Test Case 2 :
Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
*/