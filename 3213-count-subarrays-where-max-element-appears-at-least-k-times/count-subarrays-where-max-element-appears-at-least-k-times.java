class Solution {
    public long countSubarrays(int[] nums, int k) {
        

        int n = nums.length;

        // Step 1: Find maximum element of array
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        long ans = 0;        // final answer
        int left = 0;        // left pointer
        int countMax = 0;    // current window me max element ka count

        // Step 2: Sliding window
        for (int right = 0; right < n; right++) {

            // Agar max mila to count badhao
            if (nums[right] == max) {
                countMax++;
            }

            // Step 3: Jab tak condition satisfy ho rahi ho
            while (countMax >= k) {

                // right se end tak sab valid subarrays hain
                ans += (n - right);

                // Window shrink karo
                if (nums[left] == max) {
                    countMax--;
                }
                left++;
            }
        }

        return ans;
    }
}

        
    