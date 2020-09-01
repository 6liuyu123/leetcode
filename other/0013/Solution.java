import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

class Solution{
    public int movingCount(int m,int n,int k){
        int i,j,res=0;
        Pair<Integer,Integer> head;
        boolean[][] visited=new boolean[m][n];
        Queue<Pair<Integer,Integer> > visitQ=new LinkedList<Pair<Integer,Integer> >();
        if(k>=0){
            visitQ.offer(new Pair<>(0,0));
            visited[0][0]=true;
        }
        int ci,tempi,temp;
        while(!visitQ.isEmpty()){
            head=visitQ.poll();
            res++;
            i=head.getKey();
            j=head.getValue();
            if(i-1>=0&&visited[i-1][j]==false){
                visited[i-1][j]=true;
                ci=i-1;
                tempi=0;
                while(ci!=0){
                    tempi+=ci%10;
                    ci/=10;
                }
                temp=tempi;
                ci=j;
                tempi=0;
                while(ci!=0){
                    tempi+=ci%10;
                    ci/=10;
                }
                temp+=tempi;
                if(temp<=k){
                    visitQ.offer(new Pair<>(i-1,j));
                }
            }
            if(j-1>=0&&visited[i][j-1]==false){
                visited[i][j-1]=true;
                ci=i;
                tempi=0;
                while(ci!=0){
                    tempi+=ci%10;
                    ci/=10;
                }
                temp=tempi;
                ci=j-1;
                tempi=0;
                while(ci!=0){
                    tempi+=ci%10;
                    ci/=10;
                }
                temp+=tempi;
                if(temp<=k){
                    visitQ.offer(new Pair<>(i,j-1));
                }
            }
            if(i+1<m&&visited[i+1][j]==false){
                visited[i+1][j]=true;
                ci=i+1;
                tempi=0;
                while(ci!=0){
                    tempi+=ci%10;
                    ci/=10;
                }
                temp=tempi;
                ci=j;
                tempi=0;
                while(ci!=0){
                    tempi+=ci%10;
                    ci/=10;
                }
                temp+=tempi;
                if(temp<=k){
                    visitQ.offer(new Pair<>(i+1,j));
                }
            }
            if(j+1<n&&visited[i][j+1]==false){
                visited[i][j+1]=true;
                ci=i;
                tempi=0;
                while(ci!=0){
                    tempi+=ci%10;
                    ci/=10;
                }
                temp=tempi;
                ci=j+1;
                tempi=0;
                while(ci!=0){
                    tempi+=ci%10;
                    ci/=10;
                }
                temp+=tempi;
                if(temp<=k){
                    visitQ.offer(new Pair<>(i,j+1));
                }
            }
        }
        return res;
    }
}