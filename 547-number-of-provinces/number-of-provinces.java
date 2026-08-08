class Solution {
    int parent[];
    int size[];
    int n;
    int provinces;
    public int findCircleNum(int[][] isConnected) {
        
        n = isConnected.length;
        provinces = n;

        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(i, j);
                }
            }
        }

        return provinces;

    }

    public int find(int x){

        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
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

        provinces--;
    }
}