class Solution {
    int mod = 1000000007;
    public int assignEdgeWeights(int[][] edges) {

        int maxNode = 0;

        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= maxNode; i++){
            list.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean visited[] = new boolean[maxNode + 1];

        int depth = dfs(list, 1, visited);

        int[] store = new int[depth + 1];

        store[1] = 1;

        for(int i = 2; i < depth + 1; i++){
            int g = (2 * (store[i - 1]%mod))%mod;

            store[i] = g;
        }

        return store[depth];


    }

    public int dfs(List<List<Integer>> list, int node,boolean[] visited){

        int max = 0;

        visited[node] = true;

        for(int i = 0; i < list.get(node).size(); i++){

            int Node = list.get(node).get(i);

            if(visited[Node]) continue;

            max = Math.max(max, 1 +  dfs(list, Node, visited));
        }

        return max;
    }
}