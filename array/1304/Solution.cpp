#include<vector>

using namespace std;

class Solution{
    public:
    vector<int> sumZero(int n){
        vector<int> res;
        res.resize(n);
        if(n%2==1){
            for(int i=0;i<n/2;i++){
                res[i]=i+1;
                res[n-i-1]=-(i+1);
            }
            res[n/2]=0;
        }else{
            for(int i=0;i<n/2;i++){
                res[i]=i+1;
                res[n-i-1]=-(i+1);
            }
        }
        return res;
    }
};