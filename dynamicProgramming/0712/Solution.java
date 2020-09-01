class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int s1l = s1.length();
        int s2l = s2.length();
        int i, j;
        int[][] dp = new int[s1l+1][s2l+1];
        dp[s1l][s2l] = 0;
        for (i = s1l-1; i >= 0; i--) {
            dp[i][s2l] = dp[i+1][s2l] + s1.charAt(i);
        }
        for (i = s2l-1; i >= 0; i--) {
            dp[s1l][i] = dp[s1l][i+1] + s2.charAt(i);
        }                
        for (i = s1l-1; i >= 0; i--) {
            for (j = s2l-1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = dp[i+1][j]+s1.charAt(i) > dp[i][j+1]+s2.charAt(j) ? dp[i][j+1]+s2.charAt(j) : dp[i+1][j]+s1.charAt(i);
                }
            }
        }
        return dp[0][0];
    }
}