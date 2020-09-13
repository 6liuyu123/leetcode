class Solution {

    boolean[] judge = {false, false, false, false, false, false, false, false, false};
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public void findRes(int k, int j, int n) {
        if (n == 0 && k == 0) {
            List<Integer> tempRes = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                if (judge[i]) {
                    tempRes.add(i+1);
                }
            }
            res.add(tempRes);
            return;
        }
        if (n <= 0 || k == 0) {
            return;
        }
        for (int i = j; i < 9; i++) {
            if (!judge[i]) {
                judge[i] = true;
                findRes(k-1, i, n-i-1);
                judge[i] = false;
            }
        }
    }

    
    public List<List<Integer>> combinationSum3(int k, int n) {
        findRes(k, 0, n);
        return res;   
    }
}