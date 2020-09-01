class Solution{

    public int partition(int[] nums,int i,int j){
        int pivot=nums[i];
        while(i<j){
            while(i<j&&nums[j]>=pivot){
                j--;
            }
            if(i<j){
                nums[i]=nums[j];
            }
            while(i<j&&nums[i]<=pivot){
                i++;
            }
            if(i<j){
                nums[j]=nums[i];
            }
        }
        nums[i]=pivot;
        return i;
    }

    public void quickSort(int[] nums,int i,int j){
        int k=partition(nums,i,j);
        if(k-1>i){
            quickSort(nums,i,k-1);
        }
        if(k+1<j){
            quickSort(nums,k+1,j);
        }
    }

    public int[] sortArray(int[] nums){
        int n=nums.length;
        if(n<2){
            return nums;
        }
        quickSort(nums,0,n-1);
        return nums;
    }
}