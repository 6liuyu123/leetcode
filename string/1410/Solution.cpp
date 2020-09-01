#include<string>
#include<vector>

using namespace std;

class Solution{
    public:
    string entityParser(string text){
        int n=text.size();
        vector<char> vc;
        for(int i=0;i<n;i++){
            if(text[i]!='&'){
                vc.push_back(text[i]);
            }else{
                if((i+3)<n){
                    if(text[i+1]=='a'){
                        if((i+4)<n){
                            if(text[i+2]=='m'&&text[i+3]=='p'&&text[i+4]==';'){
                                vc.push_back('&');
                                i+=4;
                            }else{
                                if((i+5)<n&&text[i+2]=='p'&&text[i+3]=='o'&&text[i+4]=='s'&&text[i+5]==';'){
                                    vc.push_back('\'');
                                    i+=5;
                                }else{
                                    vc.push_back(text[i]);
                                }
                            }
                        }
                    }else if(text[i+1]=='f'){
                        if((i+6)<n&&text[i+2]=='r'&&text[i+3]=='a'&&text[i+4]=='s'&&text[i+5]=='l'&&text[i+6]==';'){
                            vc.push_back('/');
                            i+=6;
                        }else{
                            vc.push_back(text[i]);
                        }
                    }else if(text[i+1]=='g'){
                        if((i+3)<n&&text[i+2]=='t'&&text[i+3]==';'){
                            vc.push_back('>');
                            i+=3;
                        }else{
                            vc.push_back(text[i]);
                        }
                    }else if(text[i+1]=='l'){
                        if((i+3)<n&&text[i+2]=='t'&&text[i+3]==';'){
                            vc.push_back('<');
                            i+=3;
                        }else{
                            vc.push_back(text[i]);
                        }
                    }else if(text[i+1]=='q'){
                        if((i+5)<n&&text[i+2]=='u'&&text[i+3]=='o'&&text[i+4]=='t'&&text[i+5]==';'){
                            vc.push_back('\"');
                            i+=5;
                        }else{
                            vc.push_back(text[i]);
                        }
                    }else{
                        vc.push_back(text[i]);
                    }
                }
            }
        }
        string res;
        res.insert(res.begin(),vc.begin(),vc.end());
        return res;
    }
};