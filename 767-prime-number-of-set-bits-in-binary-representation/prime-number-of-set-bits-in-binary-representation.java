class Solution {
    public int countPrimeSetBits(int left, int right) {
        

        // prime set of possible bit counts
        // kyunki int me max 32 bits ho sakti hain
        Set<Integer> primeSetBits = new HashSet<>(
            Arrays.asList(2,3,5,7,11,13,17,19,23,29,31)
        );

        int count = 0;

        // left se right tak iterate karo
        for (int num = left; num <= right; num++) {

            // number of set bits count karo
            int bits = Integer.bitCount(num);

            // agar bits prime hai to answer badhao
            if (primeSetBits.contains(bits)) {
                count++;
            }
        }

        return count;
    }
}
        
