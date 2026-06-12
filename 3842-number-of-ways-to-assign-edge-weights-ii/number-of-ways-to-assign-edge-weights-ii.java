class Solution {

    private static final int MOD = 1_000_000_007;
    private static final int LOG = 18;

    int[][] parent;
    int[] depth;
    List<Integer>[] graph;
    long[] pow2;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        parent = new int[LOG][n + 1];
        depth = new int[n + 1];

        dfs(1, 0);

        for (int k = 1; k < LOG; k++) {
            for (int node = 1; node <= n; node++) {
                int p = parent[k - 1][node];
                if (p != 0) {
                    parent[k][node] = parent[k - 1][p];
                }
            }
        }

        pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            int lca = getLCA(u, v);

            int len = depth[u] + depth[v] - 2 * depth[lca];

            if (len == 0)
                ans[i] = 0;
            else
                ans[i] = (int) pow2[len - 1];
        }

        return ans;
    }

    private void dfs(int node, int par) {

        parent[0][node] = par;

        for (int next : graph[node]) {

            if (next == par)
                continue;

            depth[next] = depth[node] + 1;
            dfs(next, node);
        }
    }

    private int getLCA(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) == 1) {
                u = parent[k][u];
            }
        }

        if (u == v)
            return u;

        for (int k = LOG - 1; k >= 0; k--) {

            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        }

        return parent[0][u];
    }
}