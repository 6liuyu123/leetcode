class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int i=1, j, n=A.length;
        int count = 0;
        int[] arith = new int[n];
        if (n < 3) {
            return 0;
        }
        boolean[] judge = new boolean[n];
        for (; i<n; i++) {
            arith[i] = A[i]-A[i-1];
            judge[i] = true;
        }
        for (i=2; i<n; i++) {
            for (j=n-1; j>=i; j--) {
                if (judge[j-1] && arith[j] == arith[j-1]) {
                    count++;
                } else {
                    judge[j] = false;
                }
            }
        }
        return count;
    }
}