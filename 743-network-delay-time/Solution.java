class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            graph.get(u).add(new int[] {v, w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        pq.offer(new int[] {0, k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int dis= curr[0];
            int node = curr[1];

            if(dis > dist[node]) continue;

            for(int[] i : graph.get(node)){
                int nextNode = i[0];
                int weight = i[1];

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new int[]{dist[nextNode], nextNode});
                }
            }
        }
        int ans = 0;

        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}