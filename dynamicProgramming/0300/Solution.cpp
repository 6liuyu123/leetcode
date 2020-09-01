#include<vector>

using namespace std;

class Solution{
    public:
    int lengthOfLIS(vector<int>& nums){
        int n=nums.size();
        vector<int> res(n);
        for(int i=0;i<n;i++){
            res[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(nums[j]>nums[i]){
                    res[j]=res[j]>res[i]+1?res[j]:res[i]+1;
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(res[i]>max){
                max=res[i];
            }
        }
        return max;
    }
};