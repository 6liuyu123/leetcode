class Solution {
    List<List<Integer> > res = new ArrayList<List<Integer> >();
    List<Integer> temp = new ArrayList<Integer>();
    boolean[] visited;
    int[] num;
    int N;
    public void permute(int i, int j) {
        if (j == N) {
            List<Integer> t = new ArrayList<Integer>();
            t.addAll(temp);
            res.add(t);
            return;
        }
        int k = -100;
        for (int i1 = 0; i1 < N; i1++) {
            if (!visited[i1] && num[i1] != k) {
                k = num[i1];
                visited[i1] = true;
                temp.add(num[i1]);
                permute(i+1, j+1);
                temp.remove(temp.size()-1);
                visited[i1] = false;
            }
        }
    }


    public List<List<Integer> > permuteUnique(int[] nums) {
        int i;
        num = nums;
        int n = nums.length;
        N = n;
        visited = new boolean[n];
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        Arrays.sort(nums);
        permute(0, 0);
        return res;
    }
}