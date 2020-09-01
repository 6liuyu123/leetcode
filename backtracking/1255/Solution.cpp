#include<String>
#include<vector>

using namespace std;

class Solution{
    public:

    int max=0;
    int i,n;
    int ress[26]={0};
    vector<string> w;
    vector<int> s;

    void countMax(int l,int count){
        int wordSize=w[l].size();
        if(l!=n-1){
            countMax(l+1,count);
        }
        for(i=0;i<wordSize;i++){
            //如果字母不够
            if(ress[w[l][i]-'a']==0){
                for(i=i-1;i>=0;i--){
                    ress[w[l][i]-'a']++;
                    count-=s[w[l][i]-'a'];
                }
                return;
            }
            //字母够
            ress[w[l][i]-'a']--;
            count+=s[w[l][i]-'a'];
        }
        if(count>max){
                max=count;
        }
        if(l!=n-1){
            countMax(l+1,count);
        }
        for(i=0;i<wordSize;i++){
            ress[w[l][i]-'a']++;
            count-=s[w[l][i]-'a'];
        }
    }

    int maxScoreWords(vector<string>& words,vector<char>& letters,vector<int>& score){  
        n=letters.size();
        for(i=0;i<n;i++){
            ress[letters[i]-'a']++;
        }
        n=words.size();
        w=words;
        s=score;
        countMax(0,0);
        return max;
    }

};