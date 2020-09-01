class Solution{
    public int longestPalindrome(String s){
        int n=s.length(),i;
        int[] a=new int[52];
        int result=0;
        boolean judge=true;
        for(i=0;i<52;i++){
            a[i]=0;
        }
        for(i=0;i<n;i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                a[s.charAt(i)-'a']++;
            }else{
                a[s.charAt(i)-'A'+26]++;
            }
        }
        for(i=0;i<52;i++){
            result+=(a[i]/2*2);
            if(judge){
                if(a[i]%2==1){
                    result++;
                    judge=false;
                }
            }
        }
        return result;
    }
}