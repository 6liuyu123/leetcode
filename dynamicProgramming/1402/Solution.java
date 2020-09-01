class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[366];
        int i, j = n - 1;
        int tmp = 0;
        if (days[j] == 365) {
            dp[365] = costs[0];
            j--;
        } else {
            dp[365] = 0;
        }
        for (i = 364; i > 0; i--) {
            if (j >= 0 && days[j] == i) {
                if (i+1 <= 365) {
                    tmp = costs[0]+dp[i+1];
                }
                if (i+7 <= 365 && tmp > costs[1]+dp[i+7]) {
                    tmp = costs[1]+dp[i+7];
                }
                if (i+30 <= 365 && tmp > costs[2]+dp[i+30]) {
                    tmp = costs[2]+dp[i+30];
                }
                j--;
                dp[i] = tmp;
            } else {
                dp[i] = dp[i+1];
            }
        }
        return dp[1];
    }
}