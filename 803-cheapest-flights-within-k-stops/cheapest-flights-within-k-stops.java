class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int dist[][] = new int[n][k + 2];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        List<List<Node>> ls = new ArrayList<>();

        for (int i = 0; i < n; i++)
            ls.add(new ArrayList<>());

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];

            ls.get(u).add(new Node(v, w));

        }

        dijktra(ls, dist, src, dst, k);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= k + 1; i++) {
            ans = Math.min(ans, dist[dst][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public void dijktra(List<List<Node>> ls, int[][] dist, int src, int dst, int k) {

        Queue<pair> pq = new LinkedList<>();

        pq.add(new pair(src, 0, 0));
        dist[src][0] = 0;

        while (!pq.isEmpty()) {

            pair poll = pq.poll();
            int node = poll.node;
            int weight = poll.weight;
            int stop = poll.stop;

            if (stop > k)
                continue;

            if (weight > dist[node][stop])
                continue;

            for (Node n : ls.get(node)) {
                int N = n.node;
                int W = n.weight;

                if (stop + 1 <= k + 1 && W + weight < dist[N][stop + 1]) {

                    dist[N][stop + 1] = W + weight;

                    pq.offer(new pair(N, W + weight, stop + 1));
                }
            }
        }

    }
}

class pair {
    int node;
    int weight;
    int stop;

    pair(int node, int weight, int stop) {
        this.node = node;
        this.weight = weight;
        this.stop = stop;
    }
}

class Node {
    int node;
    int weight;

    Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}