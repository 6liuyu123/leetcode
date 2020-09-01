class Solution{
    public int massage(int[] nums){
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        int first=nums[0];
        int second=nums[1]>nums[0]?nums[1]:nums[0];
        int temp;
        for(int i=2;i<n;i++){
            temp=(nums[i]+first)>second?nums[i]+first:second;
            first=second;
            second=temp;
        }
        return second;
    }
}