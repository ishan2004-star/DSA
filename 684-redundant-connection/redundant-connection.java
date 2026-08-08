class Solution {
    int parent[];
    int size[];
    int n;
    public int[] findRedundantConnection(int[][] edges) {
        
        n = edges.length + 1;

        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(union(u, v)) return new int[]{u, v};
        }

        return new int[]{-1, -1};

    }

    public int find(int x){

        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx == rooty) return true;

        if(size[rootx] > size[rooty]){
            parent[rooty] = rootx;
            size[rootx] += size[rooty];
        }
        else{
            parent[rootx] = rooty;
            size[rooty] += size[rootx];
        }

        return false;
    }
}



        










