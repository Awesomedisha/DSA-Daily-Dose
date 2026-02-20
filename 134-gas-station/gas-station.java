class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int total = 0;   // overall gas balance check
        int tank = 0;    // current tank
        int start = 0;   // candidate starting index

        for (int i = 0; i < gas.length; i++) {

            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            // agar tank negative ho gaya → current start invalid
            if (tank < 0) {
                start = i + 1; // next station new start
                tank = 0;      // tank reset
            }
        }

        // ternary ke bina final check
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
        
    
