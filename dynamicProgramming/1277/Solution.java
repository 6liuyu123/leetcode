class Solution{
    public int countSquares(int[][] matrix){
        int n=matrix.length;
        int result=0;
        if(n==0){
            return 0;
        }
        int i,j;
        int m=matrix[0].length;
        for(i=1;i<n;i++){
            for(j=1;j<m;j++){
                if(matrix[i][j]!=0){
                    matrix[i][j]+=matrix[i-1][j-1]>matrix[i-1][j]?
                        (matrix[i-1][j]>matrix[i][j-1]?matrix[i][j-1]:matrix[i-1][j]):
                        (matrix[i-1][j-1]>matrix[i][j-1]?matrix[i][j-1]:matrix[i-1][j-1]);
                }
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                result+=matrix[i][j];
            }
        }
        return result;
    }
}