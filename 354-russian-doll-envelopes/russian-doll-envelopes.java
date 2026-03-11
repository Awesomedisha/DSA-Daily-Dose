

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // sort width ascending, height descending
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] dp = new int[envelopes.length];
        int size = 0;

        for(int[] env : envelopes){

            int height = env[1];

            int left = 0;
            int right = size;

            // binary search
            while(left < right){
                int mid = (left + right) / 2;

                if(dp[mid] < height)
                    left = mid + 1;
                else
                    right = mid;
            }

            dp[left] = height;

            if(left == size)
                size++;
        }

        return size;
    }
}
        
    