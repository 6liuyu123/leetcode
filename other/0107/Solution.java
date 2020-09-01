class Solution{
    public void rotate(int[][] matrix){
        int i,j,temp;
        int n=matrix.length;
        for(i=0;i<n/2;i++){
            for(j=i;j<n-i-1;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
    }
}