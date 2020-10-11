class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n-1, tmp;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                --p2;
            }
            if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                ++p0;
            }
        }
    }
};