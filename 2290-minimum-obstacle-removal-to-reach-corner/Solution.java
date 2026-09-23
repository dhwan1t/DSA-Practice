class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for(int[] i : dist) Arrays.fill(i, Integer.MAX_VALUE);
        dist[0][0] = grid[0][0];

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        
        int[][] dircs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!dq.isEmpty()){
            int[] curr = dq.pollFirst();

            int r = curr[0];
            int c = curr[1];
            
            if (r == m - 1 && c == n - 1) {
                return dist[r][c];
            }
    
            for(int[] dir : dircs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < m && nc>=0 && nc < n){
                    int newCost = dist[r][c] + grid[nr][nc];

                    if(newCost < dist[nr][nc]){
                        dist[nr][nc] = newCost;
                        if(grid[nr][nc] == 0){
                            dq.addFirst(new int[]{nr, nc});
                        } 
                        else {
                            dq.addLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}