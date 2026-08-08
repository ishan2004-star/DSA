class Solution {

    int result;

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        result = 0;

        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        for (int[] edge : edges) {

            if (edge[0] == 3) {

                int u = edge[1];
                int v = edge[2];

                boolean a = alice.union(u, v);
                boolean b = bob.union(u, v);

                if (!a && !b) {
                    result++;
                }
            }
        }

        for (int[] edge : edges) {

            if (edge[0] == 1) {

                int u = edge[1];
                int v = edge[2];

                if (!alice.union(u, v)) {
                    result++;
                }
            }
        }

        for (int[] edge : edges) {

            if (edge[0] == 2) {

                int u = edge[1];
                int v = edge[2];

                if (!bob.union(u, v)) {
                    result++;
                }
            }
        }

        if (alice.components != 1 || bob.components != 1) {
            return -1;
        }

        return result;
    }

    class DSU {

        int[] parent;
        int[] size;
        int components;

        DSU(int n) {

            components = n;

            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        boolean union(int x, int y) {

            int rootx = find(x);
            int rooty = find(y);

            if (rootx == rooty) {
                return false;
            }

            if (size[rootx] > size[rooty]) {
                parent[rooty] = rootx;
                size[rootx] += size[rooty];
            } else {
                parent[rootx] = rooty;
                size[rooty] += size[rootx];
            }

            components--;

            return true;
        }
    }
}