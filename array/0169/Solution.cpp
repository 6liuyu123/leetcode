#include<vector>

using namespace std;

class Solution{
    public:
    int majorityElement(vector<int>& nums){
        int major=nums[0];
        int times=1;
        int n=nums.size();
        for(int i=1;i<n;i++){
            if(major!=nums[i]){
                if(times==1){
                    major=nums[i];
                }else{
                    times--;
                }
            }else{
                times++;
            }
        }
        
        return major;
    }
};