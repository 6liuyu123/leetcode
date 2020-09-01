class Solution {
    public int countSubstrings(String s) {
        int s_length = s.length(), i, j, l, count = 0;
        boolean[][] dp = new boolean[s_length][];
        for (i = 0; i < s_length; i++) {
            dp[i] = new boolean[s_length];
            dp[0][i] = true;
            count++;
        }
        for (i = 1; i < s_length; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                dp[1][i] = true;
                count++;
            }
        }
        for (l = 2; l < s_length; l++) {
            if (l%2 == 0) {
                for (i = l/2; i < s_length-l/2; i++) {
                    if (dp[l-2][i] && s.charAt(i-l/2) == s.charAt(i+l/2)) {
                        dp[l][i] = true;
                        count++;
                    }
                }
            } else {
                for (i = l/2+1; i < s_length-l/2; i++) {
                    if (dp[l-2][i] && s.charAt(i-l/2-1) == s.charAt(i+l/2)) {
                        dp[l][i] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}