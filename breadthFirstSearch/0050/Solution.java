class Solution {
    public double myPow(double x, int n) {
        boolean judge = false;
        double result_num = 1.0;
        double powed_num = x;
        long N = (long)n;
        if (n < 0) {
            judge = true;
            N = 0 - N;
        }
        while (N > 0) {
            if( N % 2 == 1 ) {
                result_num *= powed_num;
            }
            powed_num *= powed_num;
            N /= 2;
        }
        return judge ? 1.0/result_num : result_num;
    }
}