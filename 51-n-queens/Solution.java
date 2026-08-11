class Solution {
    List<List<String>> l;
    private boolean isSafe(int row, int col, boolean[][] arr){
        for(int i = 0; i < row; i++){
            if(arr[i][col]) return false;
        }
        for(int i = row, j = col; i >= 0 && j >= 0; j--,i--){
            if(arr[i][j]) return false;
        }
        for(int i = row, j = col; i >= 0 && j < arr.length; j++,i--){
            if(arr[i][j]) return false;
        }
        return true;
    }
    private void helper(int row, boolean[][] arr){
        if(row == arr.length){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < arr.length; j++){
                    if(arr[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            l.add(new ArrayList<>(list));
            
            return; 
        }
        for(int col = 0; col < arr.length; col++){
            if(isSafe(row, col, arr)){
                arr[row][col] = true;
                helper(row + 1, arr);
                arr[row][col] = false;
            }
        }   
    }
    
    public List<List<String>> solveNQueens(int n) {
        l = new ArrayList<>();
        boolean[][] check = new boolean[n][n];
        helper(0, check);
        return l;
    }
}