class Solution {
    public int trap(int[] height){
        int n=height.length;
        int pivot=0,res=0;
        int[] rec=new int[n];
        int i;
        for(i=0;i<n;i++){
            if(pivot<height[i]){
                pivot=height[i];
                rec[i]=0;
            }else{
                rec[i]=pivot-height[i];
            }
        }
        pivot=0;
        for(i=n-1;i>=0;i--){
            if(pivot<height[i]){
                pivot=height[i];
                rec[i]=0;
            }else{
                rec[i]=pivot-height[i]>rec[i]?rec[i]:pivot-height[i];
            }
            res+=rec[i];
        }
        return res;
    }
}