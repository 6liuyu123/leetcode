class Solution {
    public int minFallingPathSum(int[][] A){
        int m = A.length;
        if (m == 0){
            return 0;
        }
        int n = A[0].length;
        int i, j, temp, res = Integer.MAX_VALUE;
        if(n == 1){
            for(i = 1; i < m; i++){
                A[i][0] += A[i-1][0];
            }
            return A[m-1][0];
        }
        for(i = 1; i < m; i++){
            A[i][0] += (A[i-1][0] > A[i-1][1] ? A[i-1][1] : A[i-1][0]);
            for(j = 1; j < n - 1; j++){
                temp = A[i-1][j-1] > A[i-1][j] ? A[i-1][j] : A[i-1][j-1];
                A[i][j] += (temp > A[i-1][j+1] ? A[i-1][j+1] : temp);
            }
            A[i][n-1] += (A[i-1][n-2] > A[i-1][n-1] ? A[i-1][n-1] : A[i-1][n-2]);
        }
        for(i = 0; i < n; i++){
            if(res > A[m-1][i]){
                res = A[m-1][i];
            }
        }
        return res;
    }
}