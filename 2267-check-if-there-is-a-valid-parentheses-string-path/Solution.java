class Solution {
    public boolean dfs(Boolean[][][] dp, char[][] grid, int r, int c, int open, int m, int n){
        if(grid[r][c] == '(')open++;
        else if(grid[r][c] == ')')open--;
        if(open < 0 || open > (m+n)/2) return false;
        if(r == m-1  && c == n-1) return open == 0;
        
        if(dp[r][c][open] != null) return dp[r][c][open];

        boolean pathExists = false;

        if(c+1 < n){
            pathExists = pathExists || dfs(dp, grid, r, c+1, open, m, n);
        }
        if(r+1 < m){
            pathExists = pathExists || dfs(dp, grid, r+1, c, open, m, n);
        }
        dp[r][c][open] = pathExists;
        return pathExists;
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if((m+n-1) % 2 != 0) return false;

        int max = (m+n)/2;
        Boolean[][][] dp = new Boolean[m][n][max+1];

        return dfs(dp, grid, 0, 0, 0, m, n);
    }
}