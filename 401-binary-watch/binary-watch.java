class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        

        List<String> result = new ArrayList<>();

        // hours: 0 to 11
        for (int h = 0; h < 12; h++) {

            // minutes: 0 to 59
            for (int m = 0; m < 60; m++) {

                // total set bits count
                int bits = Integer.bitCount(h) + Integer.bitCount(m);

                // agar LEDs match kar rahe hain
                if (bits == turnedOn) {

                    // minute ko 2-digit banana hai
                    String time = h + ":" + (m < 10 ? "0" + m : m);

                    result.add(time);
                }
            }
        }

        return result;
    }
}

        
    