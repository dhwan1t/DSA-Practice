class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int[] i : edges){
            int s = i[0];
            int e = i[1];
            int d = i[2];
            dist[s][e] = d;
            dist[e][s] = d;
        }

        for(int med=0; med<n; med++){
            for(int s=0; s<n; s++){
                for(int destination=0; destination<n; destination++){
                    if(dist[s][med] < Integer.MAX_VALUE && dist[med][destination] < Integer.MAX_VALUE){
                        dist[s][destination] = Math.min(dist[s][destination], dist[s][med]+dist[med][destination]);
                    }
                }
            }
        }

        int min = n;
        int res = -1;

        for(int s=0; s<n; s++){
            int count = 0;
            for(int d=0; d<n; d++){
                if(dist[s][d] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= min){
                min = count;
                res = s;
            }
        }
        return res;
    }
}