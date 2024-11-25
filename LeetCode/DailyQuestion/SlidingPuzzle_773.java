package DailyQuestion;
import java.util.*;

//Time Complexity: O((MN)!)
//Space Complexity: O((MN)!)

public class SlidingPuzzle_773 {
    private static final int FINAL_STATE = 0b001010011100101000;
    private static final int[][] DIRS = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length != 2 || board[0].length != 3) {
            throw new IllegalArgumentException("Input board is invalid");
        }

        int zeroIdx = -1;
        int curState = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                curState = (curState << 3) | board[i][j];
                if (board[i][j] == 0) {
                    zeroIdx = i * 3 + j;
                }
            }
        }

        if (FINAL_STATE == curState) {
            return 0;
        }
        HashSet<Integer> visited = new HashSet<>();
        int moves = 0;

        HashMap<Integer, Integer> begin = new HashMap<>();
        begin.put(curState, zeroIdx);
        visited.add(curState);

        HashMap<Integer, Integer> end = new HashMap<>();
        end.put(FINAL_STATE, 5);
        visited.add(FINAL_STATE);

        while (!begin.isEmpty()) {
            if (begin.size() > end.size()) {
                HashMap<Integer, Integer> tempSet = begin;
                begin = end;
                end = tempSet;
            }
            HashMap<Integer, Integer> next = new HashMap<>();
            moves++;
            for (int cur : begin.keySet()) {
                zeroIdx = begin.get(cur);
                for (int d : DIRS[zeroIdx]) {
                    int newState = swap(cur, zeroIdx, d);
                    if (end.containsKey(newState)) {
                        return moves;
                    }
                    if (visited.add(newState)) {
                        next.put(newState, d);
                    }
                }
            }
            begin = next;
        }
        return -1;
    }
    private int swap(int state, int zeroIdx, int destIdx) {
        int mask = 0b111 << ((5 - destIdx) * 3);
        int num = state & mask;
        if (zeroIdx < destIdx) {
            num <<= (destIdx - zeroIdx) * 3;
        } else {
            num >>>= (zeroIdx - destIdx) * 3;
        }
        state &= ~mask;
        return state | num;
    }
}
/*
Example 1:
Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.

Example 2:
Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.

Example 3:
Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]
*/





