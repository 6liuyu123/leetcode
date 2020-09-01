import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution{

    public class myComparator implements Comparator<String>{
        @Override
        public int compare(String a,String b){
            int na=a.length();
            int nb=b.length();
            if(na<nb){
                return 1;
            }else if(na==nb){
                return 0;
            }else{
                return -1;
            }
        }
    }

    public int minimumLengthEncoding(String[] words){
        int i,wordLength;
        int n=words.length;
        int result=0;
        boolean judge;
        Comparator<String> cmp=new myComparator();
        Arrays.sort(words,cmp);
        HashSet<Integer> myHash=new HashSet<Integer>();
        myHash.add(0);
        result+=words[0].length();
        for(i=1;i<n;i++){
            judge=false;
            for(Integer j:myHash){
                wordLength=words[j].length();
                if(words[j].substring(wordLength-words[i].length()).equals(words[i])){
                    judge=true;
                    break;
                }
                
            }
            if(judge){
                continue;
            }else{
                result+=words[i].length();
                myHash.add(i);
            }
        }
        return result+myHash.size();
    }

}