//62*62*62*62*62/250/250/250/250

#include<String>
#include<unordered_map>

using namespace std;

class Solution{
    private:
    unordered_map<string,string> hash;
    public:
    string encode(string longUrl){
        int n=longUrl.size();
        int i,j,k,m;
        int b;
        char f,s,t,ft;
        char* longU=new char[n+1];
        char* shortU=new char[n+1];
        strcpy(longU,longUrl.c_str());
        for(i=0,j=0;i<n;){
            k=0;
            for(m=0;i<n&&m<5;i++,m++){
                if(longU[i]>='a'&&longU[i]<='z'){
                    b=longU[i]-'a'+0;
                }else if(longU[i]>='A'&&longU[i]<='Z'){
                    b=longU[i]-'A'+26;
                }else{
                    b=longU[i]-'0'+52;
                }
                k*=62;
                k+=b;
            }
            ft=k%250;
            t=k/250%250;
            s=k/250/250%250;
            f=k/250/250/250%250;
            shortU[j++]=f;
            shortU[j++]=s;
            shortU[j++]=t;
            shortU[j++]=ft;
        }
        shortU[j]='\0';
        string shortUrl=shortU;
        hash.insert(pair<string,string>(shortUrl,longUrl));
        return shortUrl;
    }

    string decode(string shortUrl){
        return (*hash.find(shortUrl)).second;
    }
};