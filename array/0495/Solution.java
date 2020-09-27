class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int endTime = 0;
        int res = 0;      
        for (int i = 0; i < n; i++) {
            if (timeSeries[i] > endTime) {
                res += duration;
            } else {
                res +=  timeSeries[i]+duration-endTime;
            }
            endTime = timeSeries[i]+duration;
        }
        return res;
    }
}