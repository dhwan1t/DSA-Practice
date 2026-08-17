class Solution {
    public boolean isSafe(char[][] board, int i, int j, char k){
        for(int r=0; r<9; r++){
            if(r == i) continue;
            if(board[r][j] == k) return false;
        }
        for(int r=0; r<9; r++){
            if(r == j) continue;
            if(board[i][r] == k) return false;
        }
        int l = (i/3) * 3;
        int r = (j/3) * 3;
        for(int a = l; a < l + 3; a++){
            for(int b=r; b<r+3; b++){
                if(a == i && b == j) continue;
                if(board[a][b] == k) return false;
            }
        }
        return true;
    }
    
    boolean flag = false;
    public void helper(char[][] board){
        if(flag) return;    
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isSafe(board, i, j, c)){
                            board[i][j] = c;
                            helper(board);
                            if(flag) return;
                            board[i][j] = '.';
                        } 
                    }
                    return;
                }
            }
        }
        flag = true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}


/**
["5","3","1","2","7","4","8","9","."],  6
["6","2","4","1","9","5","3",".","7"],  8
[".","9","8","3",".",".","1","6","2"],  7,
["8","1","2","5","6","7","4",".","3"],
["4","5","6","8",".","3","7","2","1"],
["7",".","3","9","2","1","5",".","6"],
["1","6","5","7","3",".","2","8","4"],
["2","7",".","4","1","9","6","3","5"],
["3","4",".","6","8","2",".","7","9"]]
 */