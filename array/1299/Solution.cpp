#include<String>
#include<vector>

using namespace std;

class Solution{
    public:
    vector<int> replaceElements(vector<int>& arr){
        int tempMax=-1;
        int temp;
        int n=arr.size();
        for(int i=n-1;i>=0;i--){
            if(tempMax<arr[i]){
                temp=tempMax;
                tempMax=arr[i];
                arr[i]=temp;
            }else{
                arr[i]=tempMax;
            }
        }
        return arr;
    }
};