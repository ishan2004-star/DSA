class Solution {
    int parent[];
    int size[];
    public boolean equationsPossible(String[] equations) {
        
        int n = 26;

        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(String str : equations){

            if(str.charAt(1) != '!'){
                int u = str.charAt(0) - 'a';
                int v = str.charAt(3) - 'a';
                union(u, v);
            }
        }

        for(String str : equations){
            if(str.charAt(1) == '!'){
                int u = str.charAt(0) - 'a';
                int v = str.charAt(3) - 'a';
                boolean flag = isConnected(u, v);

                if(flag) return false;
            }
        }

        return true;
    }

    public int find(int x){

        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

    public void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx == rooty) return;

        if(size[rootx] > size[rooty]){
            parent[rooty] = rootx;
            size[rootx] += size[rooty];
        }
        else{
            parent[rootx] = rooty;
            size[rooty] += size[rootx];
        }

    }
}