class Solution {
    public int countDigitOne(int n) {
        
        long count = 0;
        long factor = 1;

        while (factor <= n) {

            long lower = n % factor;
            long current = (n / factor) % 10;
            long higher = n / (factor * 10);

            if (current == 0) {
                count += higher * factor;
            }
            else if (current == 1) {
                count += higher * factor + lower + 1;
            }
            else {
                count += (higher + 1) * factor;
            }

            factor = factor * 10;
        }

        return (int) count;
    }
}
        
    