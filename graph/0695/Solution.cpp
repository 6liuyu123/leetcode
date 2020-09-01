#include<queue>
#include<vector>

using namespace std;

class Solution{
    public:
    int maxAreaOfIsland(vector<vector<int> >& grid){
        int m=grid.size();
        int n=grid[0].size();
        int island;
        int max=0;
        int gi,gj;
        queue<int> s;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    island=1;
                    s.push(i);
                    s.push(j);
                    grid[i][j]=0;
                    while(!s.empty()){
                        gi=s.front();
                        s.pop();
                        gj=s.front();
                        s.pop();
                        if(gi-1>=0&&grid[gi-1][gj]==1){
                            grid[gi-1][gj]=0;
                            island++;
                            s.push(gi-1);
                            s.push(gj);
                        }
                        if(gj-1>=0&&grid[gi][gj-1]==1){
                            grid[gi][gj-1]=0;
                            island++;
                            s.push(gi);
                            s.push(gj-1);
                        }
                        if(gi+1<m&&grid[gi+1][gj]==1){
                            grid[gi+1][gj]=0;
                            island++;
                            s.push(gi+1);
                            s.push(gj);
                        }
                        if(gj+1<n&&grid[gi][gj+1]==1){
                            grid[gi][gj+1]=0;
                            island++;
                            s.push(gi);
                            s.push(gj+1);
                        }      
                    }
                    if(island>max){
                        max=island;
                    }
                }
            }
        }
        return max;
    }
};