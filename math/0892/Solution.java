class Solution{
    public int surfaceArea(int[][] grid){
        int n=grid.length;
        int i,j;
        int result=0;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                result+=(grid[i][j]==0?0:2+4*grid[i][j]);
                result=i-1>=0?result-(grid[i-1][j]>grid[i][j]?grid[i][j]*2:grid[i-1][j]*2):result;
                result=j-1>=0?result-(grid[i][j-1]>grid[i][j]?grid[i][j]*2:grid[i][j-1]*2):result;
            }
        }
        return result;
    }
}