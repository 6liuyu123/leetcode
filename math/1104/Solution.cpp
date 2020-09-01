#include<vector>

using namespace std;

class Solution{
    public:

    int findLevel(int label){
        int level=0;
        while(label!=0){
            label/=2;
            level++;
        }
        return level;
    }

    vector<int> pathInZigZagTree(int label){
        int level=findLevel(label);
        int w;
        vector<int> temp(level+1);
        vector<int> result(level);
        result[level-1]=label;
        int last=1;
        int i;
        for(i=0;i<=level;i++){
            temp[i]=last-1;
            last*=2;
        }
        w=level%2==1?label-temp[level-1]-1:temp[level]-label;
        for(level=level-1;level>0;level--){
            w/=2;
            result[level-1]=level%2==0?temp[level-1]+1+w:temp[level]-w;
        }
        return result;
    }

};