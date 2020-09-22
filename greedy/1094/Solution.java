class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] begin = new int[1001];
        int[] end = new int[1001];
        int n = trips.length;
        for (int i = 0; i < n; i++) {
            begin[trips[i][1]] += trips[i][0];
            end[trips[i][2]] += trips[i][0];
        }
        for (int i = 0; i <= 1000; i++) {
            capacity += end[i] - begin[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}