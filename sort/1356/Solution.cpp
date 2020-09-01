#include<vector>
#include<unordered_map>
#include<algorithm>

using namespace std;

class Solution{
    public:
    vector<int> sortByBits(vector<int>& arr){
        int i,j,min,minp;
        int n=arr.size();
        sort(arr.begin(),arr.end());
        vector<int> record=arr;
        vector<int> times(n);
        vector<int> result=arr;
        for(i=0;i<n;i++){
            times[i]=0;
        }
        for(i=0;i<n;i++){
            while(record[i]!=0){
                if(record[i]%2==1){
                    times[i]++;
                }
                record[i]/=2;
            }
        }
        for(i=0;i<n;i++){
            min=INT_MAX;
            for(j=0;j<n;j++){
                if(times[j]<min){
                    min=times[j];
                    minp=j;
                }
            }
            times[minp]=INT_MAX;
            result[i]=arr[minp];
        }
        return result;
    }
};