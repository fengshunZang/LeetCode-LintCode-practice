/*
Problem Description:
As the title described, you should only use two stacks to implement a queue's actions.
The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
Both pop and top methods should return the value of first element.
It is a possible way to realize a queue.
*/
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // initialization
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    private void stack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }    
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            stack1ToStack2();
        }   // The second stack won't be pushed by any elements from stack1 until it's empty
        return stack2.pop();
    }

    public int top() {
        if(stack2.isEmpty()) {
            stack1ToStack2();
        }
        return stack2.peek();
    }
}
