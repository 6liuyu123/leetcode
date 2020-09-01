#include<vector>
#include<unordered_set>
#include<unordered_map>
#include<string>

using namespace std;

class Solution{
    public:
    vector<string> findAndReplacePattern(vector<string>& words,string pattern){
        int i;
        int psize=pattern.size();
        int msize;
        vector<string> result;
        unordered_set<char> charSet;
        unordered_map<char,char> ref;
        unordered_map<char,char>::iterator rfind;
        for(vector<string>::iterator it=words.begin();it!=words.end();it++){
            msize=(*it).size();
            if(psize!=msize){
                continue;
            }
            for(i=0;i<psize;i++){
                charSet.insert((*it)[i]);
                rfind=ref.find(pattern[i]);
                if(rfind==ref.end()){
                    ref.insert(pair<char,char>(pattern[i],(*it)[i]));
                }else{
                    if((*rfind).second==(*it)[i]){
                        continue;
                    }else{
                        break;
                    }
                }
            }
            if(i==psize&&charSet.size()==ref.size()){
                result.push_back(*it);
            }else{
                ;
            }
            charSet.clear();
            ref.clear();
        }
        return result;
    }
};