class Solution {
    public int maxArea(int[] height){
        int i=0,j=height.length-1;
        int tempMax=0;
        int p;
        while(i<j){
            p=(height[j]>height[i]?height[i]:height[j])*(j-i);
            if(p>tempMax){
                tempMax=p;
            }
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return tempMax;
    }
}