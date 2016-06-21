class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     * Problem Description: Ugly number is a number that only have factors 2, 3 and 5.
     * Design an algorithm to find the nth ugly number.
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> uglyNumberPool = new PriorityQueue<Integer>();
        HashMap<Integer, Boolean> checkDuplicates = new HashMap<Integer, Boolean>();
        uglyNumberPool.add(1);
        checkDuplicates.put(1, true);
        int[] primes = new int[3];
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        int number = 1;
        
        for (int i = 0; i < n; i++) {
            number = uglyNumberPool.poll();
            for (int j = 0; j < 3; j++) {
                if (!checkDuplicates.containsKey(number * primes[j])) {
                    uglyNumberPool.add(number * primes[j]);
                    checkDuplicates.put(number * primes[j], true);
                }
            }
        }
        return number;
    }
};
