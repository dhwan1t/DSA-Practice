class Solution {
    private int findParent(int x, int[] parent){
        return (parent[x] == x) ? x : (parent[x] = findParent(parent[x], parent));
    }
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();

        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                edges.add(new int[] {Math.abs(points[i][0] - points[j][0])+Math.abs(points[i][1]-points[j][1]), i, j});
            }
        }
        edges.sort((a, b) -> Integer.compare(a[0], b[0]));

        int[] parent = new int[points.length];

        for(int i=0; i<points.length; i++){
            parent[i] = i;
        }

        int ans = 0;
        int used = 0;

        for(int[] e : edges){
            if(used == points.length-1) break;
            int pa = findParent(e[1], parent);
            int pb = findParent(e[2], parent);

            if(pa != pb){
                parent[Math.max(pa, pb)] = Math.min(pa, pb);
                ans += e[0];
                used++;
            }
        }
        return ans;
    }
}