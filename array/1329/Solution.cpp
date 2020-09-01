#include<vector>
#include<algorithm>

using namespace std;

class Solution{
    public:
    vector<vector<int> > diagonalSort(vector<vector<int> >& mat){
        int m=mat.size();
        int n=mat[0].size();
        vector<int> mid;
        int i,j,max;
        for(i=0;i<m-1;i++){
            max=i+1>n?n:i+1;
            for(j=0;j<max;j++){
                mid.push_back(mat[m-i+j-1][j]);
            }
            sort(mid.begin(),mid.end());
            for(j=0;j<max;j++){
                mat[m-i+j-1][j]=mid[j];
            }
            mid.clear();
        }
        for(i=0;i<n;i++){
            max=i+1>m?m:i+1;
            for(j=0;j<max;j++){
                mid.push_back(mat[j][n-i+j-1]);
            }
            sort(mid.begin(),mid.end());
            for(j=0;j<max;j++){
                mat[j][n-i+j-1]=mid[j];
            }
            mid.clear();
        }
        return mat;
    }
};