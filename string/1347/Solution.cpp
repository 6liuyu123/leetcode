#include<string>

using namespace std;

class Solution{
    public:
    int minSteps(string s,string t){
        int count=0;
        int length=s.size();
        int times[26]={0};
        for(int i=0;i<length;i++){
            times[(s[i]-'a')]++;
        }
        for(int i=0;i<length;i++){
            times[(t[i]-'a')]--;
        }
        for(int i=0;i<26;i++){
            count+=(times[i]>0?times[i]:-times[i]);
        }
        return count/2;
    }
};