#include<string>
#include<vector>

using namespace std;

class Solution{
    public:
    string freqAlphabets(string s){
        int length=s.size();
        int temp;
        char* ss=new char[length+1];
        char* chrs=new char[length+1];
        char basic='a'-1;
        char tempc;
        strcpy(ss,s.c_str());
        for(int i=0;i<=length;i++){
            chrs[i]='\0';
        }
        for(int i=0,j=0;i<length;i++,j++){
            if((i+2)<length){
                if(ss[i+2]=='#'){
                    temp=(ss[i]-'0')*10+ss[i+1]-'0';
                    tempc=basic+temp;
                    chrs[j]=tempc;
                    i+=2;
                    continue;
                }
            }
            tempc=basic+ss[i]-'0';
            chrs[j]=tempc;
        }
        return chrs;
    }
};