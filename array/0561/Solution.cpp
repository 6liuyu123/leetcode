#include<vector>
#include<algorithm>

using namespace std;

class Solution{
    public:
    int arrayPairSum(vector<int>& nums){
        sort(nums.begin(),nums.end());
        vector<int>::iterator end=nums.end();
        int count=0;
        for(vector<int>::iterator i=nums.begin();i!=end;i+=2){
            count+=(*i);
        }
        return count;
    }
};