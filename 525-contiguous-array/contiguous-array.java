

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);   // base case
        
        int maxLen = 0;
        int prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            // Treat 0 as -1 and 1 as +1
            if (nums[i] == 0) {
                prefixSum -= 1;
            } else {
                prefixSum += 1;
            }
            
            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}
