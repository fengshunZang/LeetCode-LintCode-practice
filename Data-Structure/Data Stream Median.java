public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     * Probleam Description: Numbers keep coming, return the median of numbers at every time a new number added.
     * Median is the number that in the middle of a sorted array.
     * If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. 
     */
    public int[] medianII(int[] nums) {
        int[] result = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        
        int median = nums[0];
        int index = 0;
        result[index++] = median;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= median) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(-nums[i]);
            }
            
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(median);
                median = -minHeap.peek();
                minHeap.poll();
            } else if (minHeap.size() + 1 < maxHeap.size()) {
                minHeap.add(-median);
                median = maxHeap.peek();
                maxHeap.poll();
            }
            result[index++] = median;
        }
        return result;
    }
}
