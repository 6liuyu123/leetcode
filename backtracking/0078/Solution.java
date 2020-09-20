class Solution {
    int N;
    int[] Nums;
    List<List<Integer> > res = new ArrayList<List<Integer> >();
    public void sub(boolean insert, int pos, List<Integer> t) {
        if (insert) {
            t.add(Nums[pos]);
        }
        if (pos == N) {
            res.add(t);
        } else {
            List<Integer> t1 = new ArrayList<Integer>();
            t1.addAll(t);
            sub(false, pos+1, t);
            sub(true, pos+1, t1);
        }
    }

    public List<List<Integer> > subsets(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        N = n-1;
        Nums = new int[n];
        for (int i = 0; i < n; i++) {
            Nums[i] = nums[i];
        }
        List<Integer> t1 = new ArrayList<Integer>();
        List<Integer> t2 = new ArrayList<Integer>();
        sub(false, 0, t1);
        sub(true, 0, t2);
        return res;
    }
}