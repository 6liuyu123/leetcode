import java.util.List;
import java.util.ArrayList;

class Solution {
    int N;
    List<String> res=new ArrayList<>();

    public void pCreate(char[] temp,int level,int lTimes){
        if(level==0){
            temp[0]='(';
            pCreate(temp,level+1,lTimes+1);
        }else if(level==N-1){
            if(N==2*lTimes){
                temp[N-1]=')';
                res.add(String.valueOf(temp));
            }
        }else{
            if(2*lTimes>level){
                if(lTimes==N/2){
                    temp[level]=')';
                    pCreate(temp,level+1,lTimes);
                }else{
                    temp[level]='(';
                    pCreate(temp,level+1,lTimes+1);
                    temp[level]=')';
                    pCreate(temp,level+1,lTimes);
                }
            }else{
                if(lTimes==N/2){
                    ;
                }else{
                    temp[level]='(';
                    pCreate(temp,level+1,lTimes+1);
                }
            }
        }
    }

    public List<String> generateParenthesis(int n){
        N=2*n;
        char[] temp=new char[N];
        pCreate(temp,0,0);
        return res;
    }
}