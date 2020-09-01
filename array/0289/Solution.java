class Solution {
    public void gameOfLife(int[][] board){
        int[] dx={-1,-1,-1,0,0,1,1,1,0};
        int[] dy={-1,0,1,-1,1,-1,0,1,0};
        int n=board.length;
        if(n==0){
            return;
        }
        int m=board[0].length;
        int i,j,k,temp;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                temp=0;
                for(k=0;k<9;k++){
                    if((i+dx[k])<n&&i+dx[k]>=0&&j+dy[k]<m&&j+dy[k]>=0){
                        if(board[i+dx[k]][j+dy[k]]>0){
                            temp++;
                        }
                    }
                }
                if(board[i][j]==1){
                    board[i][j]=temp;
                }else{
                    board[i][j]=-temp;
                }
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(board[i][j]==-3){
                    board[i][j]=1;
                }else if(board[i][j]<3){
                    board[i][j]=0;
                }else if(board[i][j]<=4){
                    board[i][j]=1;
                }else{
                    board[i][j]=0;
                }
            }
        }
    }
}