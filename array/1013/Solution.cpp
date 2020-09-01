#include<vector>

using namespace std;

class Solution{
    public:
    bool canThreePartsEqualSum(vector<int>& A){
        int n=A.size();
        int max=0;
        for(int i=0;i<n;i++){
            max+=A[i];
        }
        if(max%3!=0){
            return false;
        }
        int avg=max/3;
        int count=0,result=0;
        for(int i=0;i<n;i++){
            count+=A[i];
            if(count==avg){
                count=0;
                result++;
            }
        }
        if(result>=3){
            return true;
        }else{
            return false;
        }
    }
};