class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        // Find first place where sorting breaks
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // Already sorted
        if (left == n - 1) {
            return 0;
        }

        // Find last place where sorting breaks
        while (right > 0 && nums[right - 1] <= nums[right]) {
            right--;
        }

        // Find min and max in unsorted portion
        int min = nums[left];
        int max = nums[left];

        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Expand left
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        // Expand right
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
}
        
    