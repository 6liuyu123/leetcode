class Solution {

    public void r(int[] nums, int i, int j) {
        int t;
        while (i < j) {
            t = nums[j];
            nums[j--] = nums[i];
            nums[i++] = t;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k %= n;
        }
        r(nums, 0, n-k-1);
        r(nums, n-k, n-1);
        r(nums, 0, n-1);
    }
}