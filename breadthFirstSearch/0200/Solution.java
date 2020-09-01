import java.util.LinkedList;
import java.util.Queue;

class Solution{
    public int numIslands(char[][] grid){
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        int i,j,res=0;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        int tempx,tempy;
        for(i = 0;i < m;i++){
            for(j = 0;j < n;j++){
                visited[i][j] = false;
            }
        }
        for(i = 0;i < m;i++){
            for(j = 0;j < n;j++){
                if(!visited[i][j]){
                    if(grid[i][j] == '0'){
                        visited[i][j] = true;
                    }else{
                        res++;
                        x.offer(i);
                        y.offer(j);
                        visited[i][j]=true;
                        while(!x.isEmpty()){
                            tempx=x.poll();
                            tempy=y.poll();
                            if((tempx-1)>=0 && !visited[tempx-1][tempy] && grid[tempx-1][tempy] == '1'){
                                x.offer(tempx-1);
                                y.offer(tempy);
                                visited[tempx-1][tempy]=true;
                            }
                            if((tempx+1)<m && !visited[tempx+1][tempy] && grid[tempx+1][tempy] == '1'){
                                x.offer(tempx+1);
                                y.offer(tempy);
                                visited[tempx+1][tempy]=true;
                            }
                            if((tempy-1)>=0 && !visited[tempx][tempy-1] && grid[tempx][tempy-1] == '1'){
                                x.offer(tempx);
                                y.offer(tempy-1);
                                visited[tempx][tempy-1]=true;
                            }
                            if((tempy+1)<n && !visited[tempx][tempy+1] && grid[tempx][tempy+1] == '1'){
                                x.offer(tempx);
                                y.offer(tempy+1);
                                visited[tempx][tempy+1]=true;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}