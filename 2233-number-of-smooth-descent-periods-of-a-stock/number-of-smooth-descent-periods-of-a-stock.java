class Solution {
    public long getDescentPeriods(int[] prices) {
        int len=0;
        long ans=0;
        for(int i=0;i<prices.length;i++){
            if(i==0||prices[i]!=prices[i-1]-1){
                len=1;//single element itself
            }
            else{
                len++;
            }
            ans+=len;
        }
        return ans;





        
    }
}