#include<vector>

using namespace std;

class Solution{
    public:
    int peakIndexInMountainArray(vector<int>& A){
        int index=0;
        vector<int>::iterator end=A.end();
        for(vector<int>::iterator it=++A.begin();it!=end;it++){
            if((*it)<A[index]){
                break;
            }else{
                index++;
            }
        }
        return index;
    }
};