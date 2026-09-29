class Solution {
    public boolean canCross(int[] stones) {
        
        int n = stones.length;

        // dp[i] contains all jump sizes
        // with which we can reach stone i
        Set<Integer>[] dp = new HashSet[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashSet<>();
        }

        // Initially frog is at stone 0
        // No jump has been made yet
        dp[0].add(0);

        for (int i = 0; i < n; i++) {

            for (int jump : dp[i]) {

                int nextJump = jump - 1;

                if (nextJump > 0) {
                    addJump(stones, dp, i, nextJump);
                }

                nextJump = jump;

                if (nextJump > 0) {
                    addJump(stones, dp, i, nextJump);
                }

                nextJump = jump + 1;

                if (nextJump > 0) {
                    addJump(stones, dp, i, nextJump);
                }
            }
        }

        return !dp[n - 1].isEmpty();
    }

    private void addJump(
        int[] stones,
        Set<Integer>[] dp,
        int current,
        int jump
    ) {

        int target = stones[current] + jump;

        for (int i = current + 1; i < stones.length; i++) {

            if (stones[i] == target) {
                dp[i].add(jump);
                return;
            }

            if (stones[i] > target) {
                return;
            }
        }
    }
}
        
    
