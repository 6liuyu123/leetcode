import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 3){
            return res;
        }
        int left = 0, mid , right;
        for (; left <= n - 3; left++) {
            for (mid = left + 1, right = n - 1; mid < right;){
                if ((nums[left] + nums[mid] + nums[right]) == 0) {
                    res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while ((mid + 1 < right) && nums[mid] == nums[mid+1]){
                        mid++;
                    }
                    while ((right - 1 > mid) && nums[right] == nums[right-1]){
                        right--;
                    }
                    mid++;
                    right--;
                } else if ((nums[left] + nums[mid] + nums[right]) < 0) {
                    while ((mid + 1 < right) && nums[mid] == nums[mid+1]){
                        mid++;
                    }
                    mid++;
                } else {
                    while ((right - 1 > mid) && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                }
            }
            while (left < n - 3 && nums[left]==nums[left+1]){
                left++;
            }
        }
        return res;
    }
}