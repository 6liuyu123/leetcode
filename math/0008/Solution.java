class Solution {
    public int myAtoi(String str){
        long temp=0;
        int i;
        int n=str.length();
        char chr=' ';
        boolean judge=false;
        boolean rec=false;
        for(i=0;i<n;i++){
            chr=str.charAt(i);
            if(chr=='-'||(chr>='0'&&chr<='9')||chr=='+'){
                if(chr=='-'||chr=='+'){
                    if(i==n-1||str.charAt(i+1)<'0'||str.charAt(i+1)>'9'){
                        return 0;
                    }
                }
                break;
            }else if(chr==' '){
                continue;
            }else{
                return 0;
            }
        }
        for(;i<n;i++){
            chr=str.charAt(i);
            if(chr=='-'){
                if(rec){
                    break;
                }
                judge=true;
            }else if(chr=='+'){
                if(rec){
                    break;
                }
                continue;
            }else if(chr>='0'&&chr<='9'){
                rec=true;
                temp=temp*10+chr-'0';
                if(judge){
                    if(-temp<Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }else{
                    if(temp>Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
            }else{
                break;
            }
        }
        if(judge){
            temp=-temp;
        }
        return (int)temp;
    }
}