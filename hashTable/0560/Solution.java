import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int pre = 0, res = 0;
        int numSize = nums.length;
        for (int i = 0; i < numSize; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                res += mp.get(pre - k);
            }
            if (mp.containsKey(pre)) {
                mp.put(pre, mp.get(pre)+1);
            } else {
                mp.put(pre, 1);
            }
        }
        return res;
    }
}