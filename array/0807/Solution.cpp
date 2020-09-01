#include<vector>

using namespace std;

class Solution{
    public:
    int maxIncreaseKeepingSkyline(vector<vector<int> >& grid){
        int grad=0;
        int n=grid.size();
        int m=grid[0].size();
        vector<int> columnMax;
        vector<int> rowMax;
        columnMax.resize(n);
        rowMax.resize(m);
        int temp,i,j,tempLine;
        for(i=0;i<n;i++){
            temp=0;
            for(j=1;j<m;j++){
                if(grid[i][j]>grid[i][temp]){
                    temp=j;
                }
            }
            columnMax[i]=grid[i][temp];
        }
        for(i=0;i<m;i++){
            temp=0;
            for(j=1;j<n;j++){
                if(grid[j][i]>grid[temp][i]){
                    temp=j;
                }
            }
            rowMax[i]=grid[temp][i];
        }
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]!=columnMax[i]&&grid[i][j]!=rowMax[j]){
                    tempLine=columnMax[i]<rowMax[j]?columnMax[i]:rowMax[j];
                    grad+=(tempLine-grid[i][j]);
                }
            }
        }
        return grad;
    }
};