#include<unordered_set>
#include<vector>
#include<string>

using namespace std;

class Solution{
    public:
    void changeWord(char* word){
        for(int i=0;i<13;i++){
            word[i]='\0';
        }
    }
    int uniqueMorseRepresentations(vector<string>& words) {
        unordered_set<string> uss;
        string cmap[]={".-","-...","-.-." , "-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        char word[13];
        string s="";
        for(vector<string>::iterator vsi=words.begin();vsi!=words.end();vsi++){
            changeWord(word);
            strcpy(word,(*vsi).c_str());
            for(int i=0;i<13&&word[i]!='\0';i++){
                s+=cmap[word[i]-'a'];
            }
            uss.insert(s);
            s="";
        }
        return uss.size();
    }
};