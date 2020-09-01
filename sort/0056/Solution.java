import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;

class Solution{
    public int[][] merge(int[][] intervals){
        int i,n=intervals.length;
        if(n==0){
            int[][] res=new int[0][0];
            return res;
        }
        Map<Integer,Integer> seMap=new TreeMap<Integer,Integer>();
        for(i=0;i<n;i++){
            if(seMap.containsKey(intervals[i][0])){
                if(seMap.get(intervals[i][0])<intervals[i][1]){
                    seMap.put(intervals[i][0],intervals[i][1]);
                }
            }else{
                seMap.put(intervals[i][0],intervals[i][1]);
            }
        }
        List<int[] > res=new ArrayList<>();
        int begin=-1,maxEnd=-1;
        for(Map.Entry<Integer,Integer> entry:seMap.entrySet()){
            if(maxEnd<0){
                begin=entry.getKey();
                maxEnd=entry.getValue();
            }else if(maxEnd>=entry.getKey()){
                if(entry.getValue()>maxEnd){
                    maxEnd=entry.getValue();
                }
            }else{
                res.add(new int[]{begin,maxEnd});
                begin=entry.getKey();
                maxEnd=entry.getValue();
            }
        }
        res.add(new int[]{begin,maxEnd});
        return res.toArray(new int[res.size()][]);
    }
}