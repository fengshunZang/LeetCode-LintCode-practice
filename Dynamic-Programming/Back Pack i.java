public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     *Problem Description: Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
     */
    public int backPack(int m, int[] A) {
        boolean[][] f = new boolean[A.length + 1][m + 1]; // whether i items could fill j size backpack
       
        for (int i = 0; i <= A.length; i++) {
            f[i][0] = true;
        }
        for (int j = 1; j <= m; j++) {
            f[0][j] = false;
        }       // state function initialization
        
        f[0][0] = true;
        
        /*
        f[i + 1][j] could be realized by two methods:
        1. i + 1 th item not included: f[i + 1][j] = f[i][j]
        2. i + 1 th item included: f[i + 1][j] = f[i][j - A[i]] && A[i] <= j 
        */
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i + 1][j] = f[i][j];
                if(j >= A[i] && f[i][j - A[i]]) {
                    f[i + 1][j] = true;
                }
            }
        }   
        
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
}
