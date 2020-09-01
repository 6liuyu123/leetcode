class Solution {

    int n;
    List<Boolean> visited = new ArrayList<Boolean>();
    List<Integer> num = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<>();

    public void backtrack(int k) {
        if (k == n) {
            List<Integer> tRes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tRes.add(tmp.get(i));
            }
            res.add(tRes);
        }
        for (int i = 0; i < n; i++) {
            if (!visited.get(i)) {
                tmp.add(num.get(i));
                visited.set(i, true);
                backtrack(k+1);
                tmp.remove(k);
                visited.set(i, false);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;       
        for (int i = 0; i < n; i++) {
            visited.add(false);
            num.add(nums[i]);
        }
        backtrack(0);
        return res;
    }
}