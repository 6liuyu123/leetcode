#include<iostream>

using namespace std;

class Solution{
    public:
    int numberOfSteps(int num){
        if(num==0){
            return 0;
        }else{
            int count=0;
            while(num!=0){
                if(num%2==0){
                    count++;
                }else{
                    count+=2;
                }
                num=num>>1;
            }
            return count-1;
        }
    }
};