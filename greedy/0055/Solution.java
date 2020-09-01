class Solution{
    public boolean canJump(int[] nums){
        int n=nums.length;
        int most=0;
        for(int i=0;i<n;i++){
            if(most>=i){
                most=(i+nums[i])>most?(i+nums[i]):most;
                if(most>=n-1){
                    return true;
                }
            }
        }
        return false;
    }
}