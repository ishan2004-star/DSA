class Solution {

    List<List<Integer>> list;
    HashSet<Integer> hs;
    boolean visited[];

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        list = new ArrayList<>();
        hs = new HashSet<>();
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] e: invocations){
            list.get(e[0]).add(e[1]);
        }

        dfs(k);

        for(int[] edge : invocations){
            int u = edge[0];
            int v = edge[1];

            if(!hs.contains(u) && hs.contains(v)){
                List<Integer> ans = new ArrayList<>();
                for(int i = 0; i < n; i++) ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(!hs.contains(i)) ans.add(i);
        }

        return ans;
    }

    public void dfs(int node){

        hs.add(node);
        visited[node] = true;

        for(int neighbor : list.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
}