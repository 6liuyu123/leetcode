#include<vector>

using namespace std;

class Solution {
public:
    vector<int> decompressRLElist(vector<int>& nums) {
        int size=nums.size();
        int n=0;
        int freq;
        for(int i=0;i<size;i++){
            if(i%2==0){
                n+=nums[i];
            }
        }
        vector<int> out;
        out.resize(n);
        for(int i=0,j=0,k;i<size;i++){
            if(i%2==0){
                freq=nums[i];
            }else{
                for(k=0;k<freq;j++,k++){
                    out[j]=nums[i];
                }
            }
        }
        return out;
    }
};