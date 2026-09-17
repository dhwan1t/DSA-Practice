class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2) q.offer(new int[] {i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }

        int mins = 0;
        int[][] dircs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir : dircs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 && vis[nr][nc] == false) {
                        vis[nr][nc] = true;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            mins++;
        }
        return fresh == 0 ? mins : -1;
    }
}