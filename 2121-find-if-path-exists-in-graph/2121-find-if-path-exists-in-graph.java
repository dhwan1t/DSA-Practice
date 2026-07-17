class Solution {
    boolean found = false;
    public void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int start, int end){
        if(visited[start]) return;
        visited[start] = true;

        for(int i: graph.get(start)){
            if(i == end){
                found = true;
                break;
            }
            if(!visited[i]){
                dfs(graph, visited, i, end);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList());
        }

        for(int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        dfs(graph, visited, source, destination);
        return found;
    }
}