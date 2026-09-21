class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // Always run binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            int cut1 = (left + right) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int L1, R1, L2, R2;

            // Handling boundaries for L1
            if (cut1 == 0) {
                L1 = Integer.MIN_VALUE;
            } else {
                L1 = nums1[cut1 - 1];
            }

            // Handling boundaries for R1
            if (cut1 == m) {
                R1 = Integer.MAX_VALUE;
            } else {
                R1 = nums1[cut1];
            }

            // Handling boundaries for L2
            if (cut2 == 0) {
                L2 = Integer.MIN_VALUE;
            } else {
                L2 = nums2[cut2 - 1];
            }

            // Handling boundaries for R2
            if (cut2 == n) {
                R2 = Integer.MAX_VALUE;
            } else {
                R2 = nums2[cut2];
            }

            // Check if partitions are valid
            if (L1 <= R2 && L2 <= R1) {

                int total = m + n;

                // EVEN count of total elements
                if (total % 2 == 0) {
                    int leftMax = Math.max(L1, L2);
                    int rightMin = Math.min(R1, R2);
                    return (leftMax + rightMin) / 2.0;
                }

                // ODD count → median is max of left side
                else {
                    return Math.max(L1, L2);
                }
            }

            // Move partition towards left
            else if (L1 > R2) {
                right = cut1 - 1;
            }

            // Move partition towards right
            else {
                left = cut1 + 1;
            }
        }

        return 0.0;   // Should never reach here
    }
}

    
