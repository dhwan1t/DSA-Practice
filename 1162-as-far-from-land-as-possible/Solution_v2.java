class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid.length];
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid.length; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[] {i, j});
                }
                if(grid[i][j] == 0) count++;
            }
        }

        if((q.isEmpty()) || count == 0) return -1;

        int time = 0;
        int[][] dircs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            int len = q.size();
            
            for(int i=0; i<len; i++){
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for(int[] dir : dircs){
                    int nr = r+dir[0];
                    int nc = c+dir[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid.length && grid[nr][nc] == 0 && vis[nr][nc] == false){
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            time++;
        }
        return time-1;
    }
}