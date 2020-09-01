#include<string>

using namespace std;

class Solution{
    public:
    string toLowerCase(string str){
        int length=str.size();
        char* strs=new char[length+1];
        strcpy(strs,str.c_str());
        int dis='a'-'A';
        for(int i=0;i<length;i++){
            if(strs[i]<='Z'&&strs[i]>='A'){
                strs[i]+=dis;
            }
        }
        str=strs;
        return str;
    }
};