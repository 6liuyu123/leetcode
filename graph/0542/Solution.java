import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] res=new int[m][n];
        Queue<Integer> qi = new LinkedList<Integer>();
        Queue<Integer> qj = new LinkedList<Integer>();
        Queue<Integer> level = new LinkedList<Integer>();
        int i,j,tempi,tempj,templevel;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(matrix[i][j]==0){
                    res[i][j]=0;
                }else{
                    qi.offer(i);
                    qj.offer(j);
                    level.offer(0);
                    while(!qi.isEmpty()){
                        tempi=qi.poll();
                        tempj=qj.poll();
                        templevel=level.poll();
                        if((tempi-1)>=0){
                            if(matrix[tempi-1][tempj]==0){
                                res[i][j]=templevel+1;
                                break;
                            }else{
                                qi.offer(tempi-1);
                                qj.offer(tempj);
                                level.offer(templevel+1);
                            }
                        }
                        if((tempi+1)<m){
                            if(matrix[tempi+1][tempj]==0){
                                res[i][j]=templevel+1;
                                break;
                            }else{
                                qi.offer(tempi+1);
                                qj.offer(tempj);
                                level.offer(templevel+1);
                            }
                        }
                        if((tempj-1)>=0){
                            if(matrix[tempi][tempj-1]==0){
                                res[i][j]=templevel+1;
                                break;
                            }else{
                                qi.offer(tempi);
                                qj.offer(tempj-1);
                                level.offer(templevel+1);
                            }
                        }
                        if((tempj+1)<n){
                            if(matrix[tempi][tempj+1]==0){
                                res[i][j]=templevel+1;
                                break;
                            }else{
                                qi.offer(tempi);
                                qj.offer(tempj+1);
                                level.offer(templevel+1);
                            }
                        }
                    }
                    qi.clear();
                    qj.clear();
                    level.clear();
                }
            }
        }
        return res;
    }
}