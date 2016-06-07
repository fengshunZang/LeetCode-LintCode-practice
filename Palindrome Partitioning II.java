public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }  // empty case check
        
        int[] f = new int[s.length() + 1]; // the core function of this DP method. It means the least NUMBER of subpalindromes, so the minimum cut would be f[n] - 1
        boolean[][] isPalindrome = getIsPalindrome(s);
        f[0] = 0;
        
        for (int i = 1; i <= s.length(); i++) {
            f[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()] - 1; // REMEMBER minus 1 !!
    }
    
    /*
    This method returns a boolean array to check if a substring is a palindrome by its starting position and ending position.
    */
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = 0; i + 1 < s.length(); i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        
        for (int length = 2; length < s.length(); length++) {
            for (int i = 0; i + length < s.length(); i++) {
                isPalindrome[i][i + length] = isPalindrome[i + 1][i + length - 1] && s.charAt(i) == s.charAt(i + length); 
            }
        } // Another kind of DP
        return isPalindrome;
    }
}
