class Solution {
    List<Boolean> visited = new ArrayList<>();
    List<Integer> num = new ArrayList<>();
    int N, total;
    int times = 0;
    String res = "";
    boolean complete = false;

    public void back(int m) {
        if (m == N) {
            times++;
            if (times == total) {
                for (int i = 0; i < N; i++) {
                    res = res+num.get(i);
                    complete = true;
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited.get(i)) {
                    num.set(m, i+1);
                    visited.set(i, true);
                    back(m+1);
                    if (complete) {
                        return;
                    }
                    visited.set(i, false);
                }
            }
        }
    }

    public String getPermutation(int n, int k) {
        int i;
        total = k;
        N = n;
        for (i = 0; i < n; i++) {
            visited.add(false);
            num.add(0);
        }
        back(0);
        return res;
    }
}