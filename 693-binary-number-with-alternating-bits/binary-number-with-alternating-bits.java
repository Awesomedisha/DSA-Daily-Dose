class Solution {
    public boolean hasAlternatingBits(int n) {
        

        // previous bit store karenge
        int prevBit = n & 1;  // last bit nikala

        // number ko right shift karte rahenge
        n = n >> 1;

        // jab tak number khatam nahi hota
        while (n > 0) {

            // current last bit nikalo
            int currBit = n & 1;

            // agar adjacent bits same hue → fail
            if (currBit == prevBit) {
                return false;
            }

            // prev update karo next comparison ke liye
            prevBit = currBit;

            // number ko aage shift karo
            n = n >> 1;
        }

        // agar kabhi same adjacent bits nahi mile
        return true;
    }
}

    