import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

class Solution{
    public int maxDistance(int[][] grid){
        int n=grid.length;
        if(n==0){
            return 0;
        }
        int m=grid[0].length;
        boolean judge0=false;
        boolean judge1=false;
        int i,j,res=0;
        Queue<Pair<Integer,Integer> > qp=new LinkedList<Pair<Integer,Integer> >();
        Pair<Integer,Integer> p;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]==0){
                    judge0=true;
                }else{
                    qp.offer(new Pair<>(i,j));
                    judge1=true;
                }
            }
        }
        if(judge0&&judge1){
            ;
        }else{
            return -1;
        }
        while(!qp.isEmpty()){
            p=qp.poll();
            i=p.getKey();
            j=p.getValue();
            res=grid[i][j];
            if(i-1>=0){
                if(grid[i-1][j]==0){
                    grid[i-1][j]=grid[i][j]+1;
                    qp.offer(new Pair<>(i-1,j));
                }
            }
            if(i+1<n){
                if(grid[i+1][j]==0){
                    grid[i+1][j]=grid[i][j]+1;
                    qp.offer(new Pair<>(i+1,j));
                }
            }
            if(j-1>=0){
                if(grid[i][j-1]==0){
                    grid[i][j-1]=grid[i][j]+1;
                    qp.offer(new Pair<>(i,j-1));
                }
            }
            if(j+1<m){
                if(grid[i][j+1]==0){
                    grid[i][j+1]=grid[i][j]+1;
                    qp.offer(new Pair<>(i,j+1));
                }
            }
        }
        return res-1;
    }
}