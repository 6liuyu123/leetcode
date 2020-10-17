class Solution {
    int N, res = 0;
    int[] m;

    public boolean judge(int i) {
        for (int j = i-1; j >= 0; j--) {
            if ((m[i]+j-i)==m[j] || m[i]-j+i == m[j] || m[i] == m[j]) {
                return false;
            }
        }
        return true;
    }

    public void place(int i) {
        if (i == N) {
            res++;
        } else {
            for (int j = 0; j < N; j++) {
                m[i] = j;
                if (judge(i)) {
                    place(i+1);
                }
            }
        }

    }

    public int totalNQueens(int n) {
        N = n;
        m = new int[n];
        place(0);
        return res;
    }
}