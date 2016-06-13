public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canSegment = new boolean[s.length() + 1];
        
        if(s == null || s.length() == 0) {
            return true;
        }
        
        int maxLength = getMaxLength(dict);    //Ensuring length of the last word not beyond max length in dict will lower the complexity.
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {    
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String lastWord = s.substring(i - lastWordLength, i);
                if (dict.contains(lastWord)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        
        return canSegment[s.length()];
    }
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = Integer.MIN_VALUE;
        for (String s: dict) {
            maxLength = Math.max(maxLength, s.length());
        }
        return maxLength;
    }
}
