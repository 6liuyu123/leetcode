//参考快速排序思想

#include<vector>

using namespace std;

class Solution{
    public:
    vector<int> sortedSquares(vector<int>& A){
        int n=A.size();
        vector<int> v;
        v.resize(n);
        int i=0,j=n-1;
        int vi=0,vj=n-1;
        for(;i<=j;){
            if(A[i]<=0&&A[j]<=0){
                for(;i<=j;){
                    v[vi]=A[j]*A[j];
                    j--;
                    vi++;
                }
            }else if(A[i]>=0&&A[j]>=0){
                for(;i<=j;){
                    v[vi]=A[i]*A[i];
                    i++;
                    vi++;
                }
            }else{
                if(A[i]*A[i]>A[j]*A[j]){
                    v[vj]=A[i]*A[i];
                    i++;
                    vj--;
                }else{
                    v[vj]=A[j]*A[j];
                    j--;
                    vj--;
                }
            }
        }
        return v;
    }
};