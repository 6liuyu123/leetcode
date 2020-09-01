#include<string>

using namespace std;

class Solution {
public:
    string defangIPaddr(string address) {
        int locate1=address.find(".");
        int locate2=locate1+address.substr(locate1+1).find(".")+1;
        int locate3=locate2+address.substr(locate2+1).find(".")+1;
        address.replace(locate3,1,"[.]");
        address.replace(locate2,1,"[.]");
        address.replace(locate1,1,"[.]");
        return address;
    }
};