class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i, j;
        int leftP = n, rightP = n;
        boolean lj = false, rj = false, rj1 = false;
        for (i = 0; i < n; i++) {
            if (intervals[i][1] >= newInterval[0]) {
                leftP = i;
                break;
            }
        }
        for (i = 0; i < n; i++) {
            if (intervals[i][0] >= newInterval[1]) {
                rightP = i;
                break;
            }
        }
        if (leftP == n) {
            int[][] res = new int[n+1][2];
            for (i = 0; i < n; i++) {
                res[i][0] = intervals[i][0];
                res[i][1] = intervals[i][1];
            }
            res[i][0] = newInterval[0];
            res[i][1] = newInterval[1];
            return res;
        }
        if (rightP == n) {
            int[][] res = new int[leftP+1][2];
            if (newInterval[0] <= intervals[leftP][0]) {
                lj = true;
            }
            for (i = 0; i < leftP; i++) {
                res[i][0] = intervals[i][0];
                res[i][1] = intervals[i][1];
            }
            if (lj) {
                res[i][0] = newInterval[0];
            } else {
                res[i][0] = intervals[leftP][0];
            }
            if (newInterval[1] > intervals[n-1][1]) {
                res[i][1] = newInterval[1];
            } else {
                res[i][1] = intervals[n-1][1];
            }
            return res;
        }
        if (leftP == rightP) {
            if (newInterval[1] == intervals[rightP][0]) {
                int[][] res = new int[n][2];
                for (i = 0; i < n; i++) {
                    res[i][0] = intervals[i][0];
                    res[i][1] = intervals[i][1];
                }
                res[leftP][0] = newInterval[0];
                return res;
            } else {
                int[][] res = new int[n+1][2];
                for (i = 0; i < leftP; i++) {
                    res[i][0] = intervals[i][0];
                    res[i][1] = intervals[i][1];
                }
                res[leftP][0] = newInterval[0];
                res[leftP][1] = newInterval[1];
                for (i = leftP; i < n; i++) {
                    res[i+1][0] = intervals[i][0];
                    res[i+1][1] = intervals[i][1];
                }
                return res;
            }
        }
        if (newInterval[0] <= intervals[leftP][0]) {
            lj = true;
        }
        if (newInterval[1] <= intervals[rightP-1][1]) {
            rj = true;
        }
        int n1 = n;
        if (newInterval[1] == intervals[rightP][0]) {
            rj1 = true;
            n1 = n + leftP - rightP;
        } else {
            n1 = n + leftP - rightP + 1;
        }
        int[][] res = new int[n1][2];
        for (i = 0; i < leftP; i++) {
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }
        if (lj) {
            res[i][0] = newInterval[0];
        } else {
            res[i][0] = intervals[leftP][0];
        }
        if (rj) {
            res[i][1] = intervals[rightP-1][1];
        } else {
            if (rj1) {
                res[i][1] = intervals[rightP][1];
            } else {
                res[i][1] = newInterval[1];
            }
        }
        if (rj1) {
            for (j = i+1, i = rightP+1; j < n1; i++, j++) {
                res[j][0] = intervals[i][0];
                res[j][1] = intervals[i][1];
            }
        } else {
            for (j = i+1, i = rightP; j < n1; i++, j++) {
                res[j][0] = intervals[i][0];
                res[j][1] = intervals[i][1];
            }
        }
        return res;
    }
}