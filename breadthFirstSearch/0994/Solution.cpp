#include<queue>
#include<vector>

using namespace std;

class Solution{
public:
    int orangesRotting(vector<vector<int> >& grid) {
        int m=grid.size();
        int n=grid[0].size();
        int i,j,k=0;
        int level;

        vector<int> node(3);

        queue<vector<int> > waitVisit;

        vector<vector<bool> > visited(m,vector<bool>(n));

        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                visited[i][j]=false;
                if(grid[i][j]==2){
                    node[0]=i;
                    node[1]=j;
                    node[2]=0;
                    waitVisit.push(node);
                }
                if(grid[i][j]==1){
                    k++;
                }
            }
        }

        if(k==0){
            return 0;
        }

        while(!waitVisit.empty()){
            node=waitVisit.front();
            i=node[0];
            j=node[1];
            level=node[2];
            waitVisit.pop();
            if(grid[i][j]==1){
                k--;
                if(k==0){
                    return level;
                }
            }
            if(i-1>=0){
                if(grid[i-1][j]==1&&!visited[i-1][j]){
                    visited[i-1][j]=true;
                    node[0]=i-1;
                    node[1]=j;
                    node[2]=level+1;
                    waitVisit.push(node);
                }
            }
            if(j-1>=0){
                if(grid[i][j-1]==1&&!visited[i][j-1]){
                    visited[i][j-1]=true;
                    node[0]=i;
                    node[1]=j-1;
                    node[2]=level+1;
                    waitVisit.push(node);
                }
            }
            if(i+1<m){
                if(grid[i+1][j]==1&&!visited[i+1][j]){
                    visited[i+1][j]=true;
                    node[0]=i+1;
                    node[1]=j;
                    node[2]=level+1;
                    waitVisit.push(node);
                }
            }
            if(j+1<n){
                if(grid[i][j+1]==1&&!visited[i][j+1]){
                    visited[i][j+1]=true;
                    node[0]=i;
                    node[1]=j+1;
                    node[2]=level+1;
                    waitVisit.push(node);
                }
            }
        }
        return -1;
    }
};