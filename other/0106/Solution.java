class Solution{
    public String compressString(String S){
        int i;
        int n=S.length();
        if(n==0){
            return S;
        }
        String result="";
        char now=S.charAt(0);
        int times=1;
        result+=S.charAt(0);
        for(i=1;i<n;i++){
            if(now==S.charAt(i)){
                times++;
            }else{
                result+=String.valueOf(times);
                result+=S.charAt(i);
                now=S.charAt(i);
                times=1;
            }
        }
        result+=String.valueOf(times);
        if(S.length()>result.length()){
            return result;
        }else{
            return S;
        }
    }
}