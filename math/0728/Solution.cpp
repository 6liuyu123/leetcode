#include<vector>

using namespace std;

class Solution{
    public:
    vector<int> selfDividingNumbers(int left,int right){
        vector<int> vi;
        char c[6];
        int temp,bit;
        for(int i=left;i<=right;i++){
            temp=i;
            while(temp!=0){
                bit=temp%10;
                if(bit!=0&&i%bit==0){
                    temp/=10;
                    continue;
                }else{
                    break;
                }
            }
            if(temp==0){
                vi.push_back(i);
            }
        }
        return vi;
    }
};