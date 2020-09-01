class Solution{
    public int[] searchRange(int[] nums,int target){
        int n=nums.length;
        int min=0,max=n-1,mid=0;
        int[] result=new int[2];
        if(n==0){
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        while(min<=max){
            mid=(min+max)/2;
            if(nums[mid]==target){
                break;
            }else if(nums[mid]<target){
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        if(nums[mid]!=target){
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        min=mid;
        max=mid;
        boolean judge=true;
        while(judge){
            judge=false;
            if(min==0){
                ;
            }else{
                if(nums[min-1]==target){
                    judge=true;
                    min--;
                }
            }
            if(max==n-1){
                ;
            }else{
                if(nums[max+1]==target){
                    judge=true;
                    max++;
                }
            }
        }
        result[0]=min;
        result[1]=max;
        return result;
    }
}