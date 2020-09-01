#include<string>
#include<vector>

using namespace std;

class Solution{
    public:
    string gcdOfStrings(string str1,string str2){
        if(str1+str2!=str2+str1){
            return "";
        }
        int n1=str1.size();
        int n2=str2.size();
        int tempn;
        string res;
        string temps;
        if(n1==n2){
            return str1;
        }
        if(n1<n2){
            tempn=n1;
            temps=str1;
            n1=n2;
            str1=str2;
            n2=tempn;
            str2=temps;
        }
        res=str1.substr(n2-1,n1);
        int resn=res.size();
        if(str2==res){
            return res;
        }else{
            return gcdOfStrings(str2,res);
        }
    }
};