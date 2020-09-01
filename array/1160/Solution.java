class Solution{
    public int countCharacters(String[] words,String chars){
        int[] charTimes=new int[26];
        int[] temp=new int[26];
        int i,j,k,wordSize;
        int result=0;
        int n=chars.length();
        for(i=0;i<26;i++){
            charTimes[i]=0;
        }
        for(i=0;i<n;i++){
            charTimes[(chars.charAt(i)-'a')]++;
            temp[(chars.charAt(i)-'a')]++;
        }
        n=words.length;
        for(i=0;i<n;i++){
            wordSize=words[i].length();
            for(j=0;j<wordSize;j++){
                if(charTimes[(words[i].charAt(j)-'a')]==0){
                    break;
                }else{
                    charTimes[(words[i].charAt(j)-'a')]--;
                }
            }
            if(j==wordSize){
                result+=wordSize;
            }
            for(k=0;k<26;k++){
                charTimes[k]=temp[k];
            }
        }
        return result;
    }
}