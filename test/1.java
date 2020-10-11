class Solution {
    int res = 0;
    int minus = 0;
    int N, K;

    public void paint(int i, int j) {
        if (i == N || j == N) {
            return;
        }
        if ((i*N+(N-i)*j) == K) {
            int res1 = 1;
            for (int i1 = 0; i1 < i; i1++) {
                res1 *= (N-i1)/(i1+1);
            }
            for (int i2 = 0; i2 < j; i1++) {
                res1 *= (N-i2)/(i2+1);
            }
            if (i == j) {
                minus = res1;
            }
            res += res1;
        }
        if ((i*N+(N-i)*j) > K) {
            return;
        }
        paint(i+1, j);
        paint(i, j+1);
    }


    public int paintingPlan(int n, int k) {
        N = n;
        K = k;
        if (k < n || k > n*n) {
            return 0;
        }
        if (k == n*n || k == 0) {
            return 1;
        }
        paint(0, 0);
        return res - minus;
    }
}