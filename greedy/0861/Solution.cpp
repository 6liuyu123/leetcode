#include<vector>

using namespace std;

class Solution{
    public:
    int matrixScore(vector<vector<int> >& A){
        int m=A.size();
        int n=A[0].size();
        int i,j,k;
        int base=1;
        int count;
        for(i=1;i<n;i++){
            base*=2;
        }
        for(i=0;i<m;i++){
            if(A[i][0]==0){
                for(j=0;j<n;j++){
                    A[i][j]=A[i][j]==0?1:0;
                }
            }
        }
        count+=base*m;
        for(j=1;j<n;j++){
            base/=2;
            k=0;
            for(i=0;i<m;i++){
                if(A[i][j]==1){
                    k++;
                }
            }
            count+=base*(m-k>k?m-k:k);
        }
        return count;
    }
};