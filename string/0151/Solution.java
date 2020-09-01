class Solution {
    public String reverseWords(String s){
        String[] str=s.trim().split(" +");
        int n=str.length;
        if(n==0){
            return "";
        }
        String res=str[n-1];
        for(int i=n-2;i>=0;i--){
            res+=(" "+str[i]);
        }
        return res;
    }
}