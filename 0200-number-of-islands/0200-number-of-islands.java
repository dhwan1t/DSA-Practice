class Solution {
    public void helper(int i, int j, char[][] grid, boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0' || visited[i][j]) return;

        visited[i][j] = true;
        helper(i+1, j, grid, visited);
        helper(i-1, j, grid, visited);
        helper(i, j+1, grid, visited);
        helper(i, j-1, grid, visited);
    }
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    helper(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
}