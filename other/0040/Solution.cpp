#include<vector>
#include<algorithm>

using namespace std;

class Solution{
    public:
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        int i,j,n=arr.size(),change,temp;
        vector<int> result(k);
        for(i=0;i<k;i++){
            for(j=n/2;j>=0;j--){
                change=j;
                if((j*2+1)<n&&arr[j]>arr[j*2+1]){
                    change=j*2+1;
                }
                if((j*2+2)<n&&arr[change]>arr[j*2+2]){
                    change=j*2+2;
                }
                if(change!=j){
                    temp=arr[j];
                    arr[j]=arr[change];
                    arr[change]=temp;
                }
            }
            result[i]=arr[0];
            arr[0]=arr[n-1];
            n--;
        }
        return result;
    }
};