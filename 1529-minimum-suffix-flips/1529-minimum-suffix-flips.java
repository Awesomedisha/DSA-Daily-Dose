class Solution {
    public int minFlips(String target) {
        

        int flips = 0;

        for (int i = 0; i < target.length(); i++) {

            int currentBit = flips % 2;

            int targetBit = target.charAt(i) - '0';

            if (currentBit != targetBit) {
                flips++;
            }
        }

        return flips;
    }
}
        