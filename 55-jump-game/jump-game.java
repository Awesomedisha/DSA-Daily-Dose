class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReach = 0; // abhi tak maximum reachable index

        for (int i = 0; i < nums.length; i++) {

            // agar current index reachable nahi hai
            if (i > maxReach) {
                return false; // yahin phas gaye
            }

            // maximum reach update karo
            maxReach = Math.max(maxReach, i + nums[i]);

            // optional early exit (optimization)
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}

        
    