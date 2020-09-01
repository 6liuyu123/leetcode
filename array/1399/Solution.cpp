#include<unordered_map>

using namespace std;

class Solution {
public:
    int countLargestGroup(int n) {
        unordered_map<int,int> mySet;
        int tempRes,tempi;
        for(int i=1;i<=n;i++){
            tempRes=0;
            tempi=i;
            while(tempi!=0){
                tempRes+=tempi%10;
                tempi/=10;
            }
            if(mySet.find(tempRes)==mySet.end()){
                mySet[tempRes]=1;
            }else{
                mySet.find(tempRes)->second++;
            }
        }
        tempi=0;
        tempRes=0;
        for(unordered_map<int,int>::iterator it=mySet.begin();it!=mySet.end();it++){
            if(it->second>tempi){
                tempi=it->second;
                tempRes=1;
            }else if(it->second==tempi){
                tempi=it->second;
                tempRes++;
            }else{
                continue;
            }
        }
        return tempRes;
    }
};