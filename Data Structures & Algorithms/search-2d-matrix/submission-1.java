class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowIdx = findRowIdx(matrix, target);
        if(rowIdx == -1) return false;
        int sc = 0;
        int ec = n - 1;

        while (sc <= ec) {
            int mc = sc + (ec - sc)/2;
            int currNum = matrix[rowIdx][mc];
            if(target == currNum) {
                return true;
            } else if (target < currNum) {
                ec = mc - 1;
            } else {
                sc = mc + 1;
            }
        }
        return false;
    }

    private int findRowIdx(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sr = 0;
        int er = matrix.length - 1;
        while (sr <= er) {
            int mr = sr + (er - sr)/2;
            int ms = matrix[mr][0];
            int me = matrix[mr][n-1];
            if(ms <= target && me >= target) {
                return mr;
            } else if (target > me) {
                sr = mr + 1;
            } else {
                er = mr - 1;
            }
        }
        return -1;
    }
}
