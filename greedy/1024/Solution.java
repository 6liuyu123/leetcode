class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] maxj = new int[T+1];
        for (int[] clip: clips) {
            if (clip[0] > T) {
                continue;
            }
            maxj[clip[0]] = Math.max(clip[1], maxj[clip[0]]);
        }
        int temp = T, tempj = 0;;
        int res = 0;
        int i, j, tempi = T;
        for(i = 0; i <= T; i = tempi) {
            res++;
            temp = maxj[i];
            if (temp >= T) {
                return res;
            } else {
                for (j = i; j <= temp; j++) {
                    if (maxj[j] > tempj) {
                        tempi = j;
                        tempj = maxj[j];
                    }
                }
                if (tempj <= temp) {
                    return -1;
                }
            }
        }
        return res;
    }
}