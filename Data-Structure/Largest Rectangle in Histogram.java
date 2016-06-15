public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     * Problem Description: Given n non-negative integers representing the histogram's bar height
     * where the width of each bar is 1, find the area of largest rectangle in the histogram. 
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        //Increasing stack is applied to get the information about which is the first left/right element less than every height.
        //Each position can calculate a rectangle area if knowing its left and right boundary(first element less than it)
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length)? -1 : height[i];   // -1 can pop out all the elements left in the stack
            
            while (!stack.isEmpty() && cur < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty()? i: i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            
            stack.push(i);
        }
        
        return max;
    }
}
