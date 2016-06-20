public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     * Problem Description: Given an integer array, heapify it into a min-heap array.
     * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i]
     * and A[i * 2 + 2] is the right child of A[i].
     */
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
          return;
        }
        //the bottom row of heap can already be deemed as a heapified array, so i starts from half number of nodes.
        for (int i = A.length / 2; i>= 0; i--) {
            trickleDown(A, i);
        }
    }
    
    private void trickleDown(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            
            if (2 * k + 1 < A.length && A[2 * k + 1] < A[smallest]) {
                smallest = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[2 * k + 2] < A[smallest]) {
                smallest = 2 * k + 2;
            }
            if (smallest == k) {
                break;
            }
            
            int temp = A[k];
            A[k] = A[smallest];
            A[smallest] = temp;
            
            k = smallest;
        }
    } 
}
