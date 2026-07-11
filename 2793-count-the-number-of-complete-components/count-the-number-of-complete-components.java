class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> ls = new ArrayList<>();

        for(int i = 0; i < n; i++){
            ls.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int v = edges[i][0];
            int u = edges[i][1];

            ls.get(u).add(v);
            ls.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(help(ls, visited, i))count++;
            }
        }

        return count;
    }

    public boolean help(List<List<Integer>> ls, boolean[] visited, int node){

        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;

        int count = 1;

        while(!q.isEmpty()){

            int poll = q.poll();
            
            for(int i = 0; i < ls.get(poll).size(); i++){
                int neighbor = ls.get(poll).get(i);
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                    count++;
                }
            }
        }

        boolean flag[] = new boolean[ls.size()];

        q.add(node);

        flag[node] = true;

        while(!q.isEmpty()){
            int poll = q.poll();

            if(ls.get(poll).size() != count - 1) return false;

            for(int i = 0; i < ls.get(poll).size(); i++){
                int neighbor = ls.get(poll).get(i);
                if(!flag[neighbor]){
                    flag[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return true;
    }
}