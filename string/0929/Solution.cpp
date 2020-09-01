#include<string>
#include<vector>
#include<unordered_set>

using namespace std;

class Solution{
    public:
    int numUniqueEmails(vector<string>& emails){
        bool localJudge=false;
        string tempString;
        unordered_set<string> email;
        vector<char> change,temp;
        vector<string>::iterator end=emails.end();
        for(vector<string>::iterator i=emails.begin();i!=end;i++){
            change.resize((*i).size());
            change.assign((*i).begin(),(*i).end());
            localJudge=false;
            for(vector<char>::iterator j=change.begin();j!=change.end();j++){
                if((*j)=='.'){
                    if(localJudge){
                        temp.push_back('.');
                    }else{
                        continue;
                    }
                }else if((*j)=='+'){
                    while((*j)!='@'&&(j!=change.end())){
                        j++;
                    }
                    if((*j)=='@'){
                        localJudge=true;
                        temp.push_back((*j));
                    }else{
                        break;
                    }
                }else if((*j)=='@'){
                    localJudge=true;
                    temp.push_back((*j));
                }else{
                    temp.push_back((*j));
                }
            }
            change.clear();
            tempString="";
            tempString.insert(tempString.begin(),temp.begin(),temp.end());
            email.insert(tempString);
            temp.clear();
        }
        return email.size();
    }
};