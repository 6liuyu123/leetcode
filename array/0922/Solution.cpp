#include<vector>

using namespace std;

class Solution{
    public:
    vector<int> sortArrayByParityII(vector<int>& A){
        if(A.empty()){
            return A;
        }
        int A_size=A.size();
        int i=0,j=A_size-1,temp;
        while(i<=A_size-2){
            while(i<=A_size-2){
                if(A[i]%2==0){
                    i+=2;
                }else{
                    break;
                }
            }
            while(j>=1){
                if(A[j]%2==1){
                    j-=2;
                }else{
                    break;
                }
            }
            if(i<=A_size-2){
                temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }
            i+=2;
            j-=2;   
        }
        return A;
    }
};