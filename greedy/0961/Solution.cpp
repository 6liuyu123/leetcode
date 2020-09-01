#include<vector>

using namespace std;

class Solution{
    public:
    int repeatedNTimes(vector<int>& A) {
        int tempPrior=A[0];
        int tempPrior1;
        int tempCount=1;
        int count=0;
        int n=A.size();
        int i;
        for(i=1;i<n;i++){
            if(A[i]!=tempPrior){
                tempCount--;
                if(tempCount==0){
                    tempPrior1=tempPrior;
                    tempPrior=A[i];
                    tempCount=1;
                }
            }else{
                tempCount++;
            }
        }
        for(i=0;i<n;i++){
            if(A[i]==tempPrior){
                count++;
            }
        }
        if(count>=n/2){
            return tempPrior;
        }else{
            count=0;
            for(i=0;i<n;i++){
            if(A[i]==tempPrior1){
                count++;
            }
        }
        }
        if(count>=n/2){
            return tempPrior1;
        }else{
            return 0;
        }
    }
};