#include<vector>

using namespace std;

class Solution{
    public:
    vector<vector<int> > matrixBlockSum(vector<vector<int> >& mat,int k){
        if(mat.empty()){
            return mat;
        }
        int i,j,p;
        int m=mat.size();
        int n=mat[0].size();
        vector<vector<int> > result(m,vector<int>(n));
        result[0][0]=0;
        for(i=0;i<=k&&i<m;i++){
            for(j=0;j<=k&&j<n;j++){
                result[0][0]+=mat[i][j];
            }
        }
        for(i=1;i<n;i++){
            result[0][i]=result[0][i-1];
            for(j=0;j<=k&&j<m;j++){
                if(i-k-1>=0){
                    result[0][i]-=mat[j][i-k-1];
                }
                if(i+k<n){
                    result[0][i]+=mat[j][i+k];
                }
            }
        }
        for(i=1;i<m;i++){
            for(j=0;j<n;j++){
                result[i][j]=result[i-1][j];
                for(p=-k;p<=k;p++){
                    if(i-k-1>=0&&j+p>=0&&j+p<n){
                        result[i][j]-=mat[i-k-1][j+p];
                    }
                    if(i+k<m&&j+p>=0&&j+p<n){
                        result[i][j]+=mat[i+k][j+p];
                    }
                }
            }
        }
        return result;
    }
};