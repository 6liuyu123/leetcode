#include<vector>

using namespace std;

class Solution{
    public:
    vector<vector<int> > map;
    int n;
    int m;
    int total;
    int result;

    void find(int i,int j,int count){
        if(map[i][j]==2&&count==total){
            result++;
            return;
        }
        if(map[i][j]==0){
            count++;
        }
        int tempBegin;
        tempBegin=map[i][j];
        if(i+1<n){
            if(map[i+1][j]==0||map[i+1][j]==2){
                map[i][j]=-1;
                find(i+1,j,count);
                map[i][j]=tempBegin;
            }
        }
        if(i-1>=0){
            if(map[i-1][j]==0||map[i-1][j]==2){
                map[i][j]=-1;
                find(i-1,j,count);
                map[i][j]=tempBegin;
            }
        }
        if(j+1<m){
            if(map[i][j+1]==0||map[i][j+1]==2){
                map[i][j]=-1;
                find(i,j+1,count);
                map[i][j]=tempBegin;
            }
        }
        if(j-1>=0){
            if(map[i][j-1]==0||map[i][j-1]==2){
                map[i][j]=-1;
                find(i,j-1,count);
                map[i][j]=tempBegin;
            }
        }
    }

    int uniquePathsIII(vector<vector<int> >& grid){
        if(grid.empty()){
            return 0;
        }
        bool judge=false;
        result=0;
        total=0;
        n=grid.size();
        m=grid[0].size();
        map=grid;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    total++;
                }
            }
        }
        for(int i=0;i<n&&!judge;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    find(i,j,0);
                    judge=true;
                    break;
                }
            }
            if(judge){
                break;
            }
        }
        return result;
    }
};