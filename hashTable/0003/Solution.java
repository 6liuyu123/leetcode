public class Solution{
    public int lengthOfLongestSubstring(String s){
        int n=s.length(),i;
        int temp;
        int res=0;
        int line=0;
        int maxtemp=-1;
        boolean judge=false;
        int[] myHash=new int[128];
        for(i=0;i<128;i++){
            myHash[i]=-1;
        }
        for(i=0;i<n;i++){
            line++;
            temp=(int)s.charAt(i);
            if(myHash[temp]==-1){
                myHash[temp]=i;
                if(line>res){
                    res=line;
                }
            }else{
                if(myHash[temp]<maxtemp){
                    myHash[temp]=maxtemp;
                }else{
                    maxtemp=myHash[temp];
                }
                judge=true;
                if(i-myHash[temp]>res){    
                    maxtemp=myHash[temp];
                    res=i-myHash[temp];
                    
                }
                line=i-myHash[temp];
                myHash[temp]=i;
            }
        }
        if(!judge){
            return n;
        }
        return res;
    }
}