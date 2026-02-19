class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
    

        // Store elements of nums1
        HashSet<Integer> set1 = new HashSet<>();

        // Store unique intersection elements
        HashSet<Integer> resultSet = new HashSet<>();

        // Step 1: Add nums1 elements into set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Step 2: Check nums2 elements
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num); // ensures uniqueness
            }
        }

        // Step 3: Convert set to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}

    