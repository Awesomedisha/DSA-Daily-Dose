class Solution {
    public int maxSubArray(int[] nums) {
        int maxcount=nums[0];
        int currentsum=0;
        for(int i=0;i<nums.length;i++){
            currentsum=currentsum+nums[i];
            maxcount=Math.max(maxcount,currentsum);
            if(currentsum<0){
                currentsum=0;  //reset
            }


        }
        return maxcount;
        
    }
}