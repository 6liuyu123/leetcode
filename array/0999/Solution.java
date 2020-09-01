class Solution{
    public int numRookCaptures(char[][] board){
        int n=board.length;
        int i,j,ri=0,rj=0;
        int result=0;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(board[i][j]=='R'){
                    ri=i;
                    rj=j;
                }
            }
        }
        if(board[ri][rj]!='R'){
            return 0;
        }
        for(i=ri-1;i>=0;i--){
            if(board[i][rj]=='B'){
                break;
            }
            if(board[i][rj]=='p'){
                result++;
                break;
            }
        }
        for(i=ri+1;i<n;i++){
            if(board[i][rj]=='B'){
                break;
            }
            if(board[i][rj]=='p'){
                result++;
                break;
            }
        }
        for(j=rj-1;j>=0;j--){
            if(board[ri][j]=='B'){
                break;
            }
            if(board[ri][j]=='p'){
                result++;
                break;
            }
        }
        for(j=rj+1;j<n;j++){
            if(board[ri][j]=='B'){
                break;
            }
            if(board[ri][j]=='p'){
                result++;
                break;
            }
        }
        return result;
    }
}