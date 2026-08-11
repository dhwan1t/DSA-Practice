class Solution {
    private boolean isSafe(int row, int col, boolean[][] arr){
        for(int i=row; i>= 0; i--){
            if(arr[i][col] == true) return false;
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(arr[i][j] == true) return false;
        }
        for(int i=row, j=col; i>=0 && j<arr.length; i--,j++){
            if(arr[i][j] == true) return false;
        }
        return true;
    }
    private int helper(int row, boolean[][] arr){
        if(row == arr.length){
            return 1;
        }
        
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(isSafe(row, i, arr)){
                arr[row][i] = true;
                count += helper(row+1, arr);
                arr[row][i] = false;
            }
        }
        return count;
    }
    
    public int totalNQueens(int n) {
        boolean[][] arr = new boolean[n][n];
        return helper(0, arr);
    }
}