class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for(int[] i : dist){
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] dircs = {{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(cost > dist[r][c]){
                continue;
            }

            if(r == m - 1 && c == n - 1){
                return cost;
            }

            for(int dir = 1; dir <= 4; dir++){
                int nr = r + dircs[dir][0];
                int nc = c + dircs[dir][1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int addCost = (grid[r][c] == dir) ? 0 : 1;
                    int newCost = cost + addCost;

                    if(newCost < dist[nr][nc]){
                        dist[nr][nc] = newCost;
                        pq.offer(new int[]{newCost, nr, nc});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}