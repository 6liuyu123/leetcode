class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m*n-1;
        int mid;
        int midi, midj;
        while (l <= r) {
            mid = (l+r)/2;
            midi = mid/n;
            midj = mid%n;
            if (matrix[midi][midj] < target) {
                l = mid+1;
            } else if (matrix[midi][midj] == target) {
                return true;
            } else {
                r = mid-1;
            }
        }
        return false;
    }
}