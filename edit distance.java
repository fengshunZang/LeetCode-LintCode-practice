public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        int[][] minDistance = new int[word1.length() + 1][word2.length() + 1];
        minDistance[0][0] = 0;
        
        //Initialization of boundary
        for (int i = 1; i <= word1.length(); i++) {
            minDistance[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            minDistance[0][i] = i;
        }
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minDistance[i][j] = Math.min(Math.min(minDistance[i - 1][j - 1], minDistance[i - 1][j] + 1), minDistance[i][j - 1] + 1);
                } else {
                    minDistance[i][j] = Math.min(Math.min(minDistance[i - 1][j - 1] + 1, minDistance[i - 1][j] + 1), minDistance[i][j - 1] + 1);
                }
            }
        }
        return minDistance[word1.length()][word2.length()];
    }
}
