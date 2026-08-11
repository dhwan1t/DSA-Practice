class Solution {
    private int helper(int i, int j, int[][] grid, int count){
        if(i < 0 || j <0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) return 0;
        
        if(grid[i][j] == 2){
            if(count == 0) return 1;
            return 0;
        }
        int ans = 0;
        int x = grid[i][j];
        grid[i][j] = -1;
        if(x == 0)
            count--;
        ans += helper(i+1, j, grid, count);
        ans += helper(i, j+1, grid, count);
        ans += helper(i-1, j, grid, count);
        ans += helper(i, j-1, grid, count);
        grid[i][j] = x;
        // count++;
        return ans;
    }
    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int start1 = 0;
        int start2 = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    count++;
                }
                if(grid[i][j] == 1){
                    start1 = i;
                    start2 = j;
                }
            }
        }
        return helper(start1, start2, grid, count);
    }
}