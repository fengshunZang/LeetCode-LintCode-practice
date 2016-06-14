/*
  Problem Description: 
  Implement a stack with min() function, which will return the smallest number in the stack.
  It should support push, pop and min operation all in O(1) cost.
*/
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>(); // key point to the solution. 
        //Set another parallel stack to record the minimum value between the current node and original node.
    }

    public void push(int number) {
        stack.push(number);
        if(minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
