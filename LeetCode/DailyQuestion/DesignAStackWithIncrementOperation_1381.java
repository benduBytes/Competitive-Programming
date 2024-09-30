package DailyQuestion;

//Time Complexity: O(1)ForPush,O(1)ForPop,O(K)ForIncrement
//Space Complexity: O(N)

class DesignAStackWithIncrementOperation_1381 {
    int [] stack;
    int top = -1;

    public DesignAStackWithIncrementOperation_1381(int maxSize) {
        this.stack = new int [maxSize];
    }
    
    public void push(int x) {
        if (top < this.stack.length - 1) {
            top ++;
            this.stack[top] = x;
        }
    }
    
    public int pop() {
        if (top != -1) {
            return this.stack[top --];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, top + 1); i ++) {
            this.stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

/*
Example 1:

Input
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
Output
[null,null,null,2,null,null,null,null,null,103,202,201,-1]
Explanation
CustomStack stk = new CustomStack(3); // Stack is Empty []
stk.push(1);                          // stack becomes [1]
stk.push(2);                          // stack becomes [1, 2]
stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
stk.push(2);                          // stack becomes [1, 2]
stk.push(3);                          // stack becomes [1, 2, 3]
stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
stk.increment(5, 100);                // stack becomes [101, 102, 103]
stk.increment(2, 100);                // stack becomes [201, 202, 103]
stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
stk.pop();                            // return -1 --> Stack is empty return -1.
*/