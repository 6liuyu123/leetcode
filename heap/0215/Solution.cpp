#include<vector>
#include<algorithm>

using namespace std;

class Solution{
    public:
    int findKthLargest(vector<int>& arr, int k) {
        int i,j,n=arr.size(),change,temp;
        for(i=n/2-1;i>=0;i--){
            for(j=i;j<n/2;){
                change=j;
                if((j*2+1)<n&&arr[j]<arr[j*2+1]){
                    change=j*2+1;
                }
                if((j*2+2)<n&&arr[change]<arr[j*2+2]){
                    change=j*2+2;
                }
                if(j==change){
                    break;
                }else{
                    temp=arr[j];
                    arr[j]=arr[change];
                    arr[change]=temp;
                    j=change;
                }
            }
        }
        n--;
        for(i=1;i<k;i++){
            arr[0]=arr[n];
            n--;
            for(j=0;j<n/2;){
                change=j;
                if((j*2+1)<n&&arr[j]<arr[j*2+1]){
                    change=j*2+1;
                }
                if((j*2+2)<n&&arr[change]<arr[j*2+2]){
                    change=j*2+2;
                }
                if(j==change){
                    break;
                }else{
                    temp=arr[j];
                    arr[j]=arr[change];
                    arr[change]=temp;
                    j=change;
                }
            }
        }
        return arr[0];
    }
};