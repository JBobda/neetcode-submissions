class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        
        int r = 0;
        int c = matrix[0].length - 1;
        int topRight = matrix[r][c];

        while(r < matrix.length && c >= 0) {
            int value = matrix[r][c];
            if(value < target) {
                r++;
            } else if(value > target) {
                c--;
            } else {
                return true;
            }
        }

        return false;
    }
}
