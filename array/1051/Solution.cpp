#include<algorithm>
#include<vector>

using namespace std;

class Solution{
    public:
    int heightChecker(vector<int>& height){
        int count=0;
        int n=height.size();
        vector<int> compare=height;
        sort(compare.begin(),compare.end());
        for(int i=0;i<n;i++){
            if(height[i]!=compare[i]){
                count++;
            }
        }
        return count;
    }
};