class Solution {
    public int countPrimeSetBits(int left, int right) {
        

    
        Set<Integer> primeSetBits = new HashSet<>(
            Arrays.asList(2,3,5,7,11,13,17,19,23,29,31)
        );

        int count = 0;

    
        for (int num = left; num <= right; num++) {

        
            int bits = Integer.bitCount(num);

        
            if (primeSetBits.contains(bits)) {
                count++;
            }
        }

        return count;
    }
}
        
