class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        int max = -1;
        if (n == 0) {
            return true;
        }
        for (int num: nums) {
            total += num;
            if (num > max) {
                max = num;
            }
        }
        if (total%2 == 1 || total/2 < max) {
            return false;
        }
        if (total/2 == max) {
            return true;
        }
        boolean[][] dp = new boolean[n][total/2+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= total/2; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][total/2];
    }
}