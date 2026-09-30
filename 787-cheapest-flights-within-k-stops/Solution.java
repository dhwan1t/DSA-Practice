class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0; i<=k; i++){
            int[] temp = dist.clone();

            for(int[] f : flights){
                int s = f[0];
                int d = f[1];
                int price = f[2];
                if (dist[s] != Integer.MAX_VALUE && dist[s] + price < temp[d]) {
                    temp[d] = dist[s] + price;
                }
            }
            dist = temp;
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}