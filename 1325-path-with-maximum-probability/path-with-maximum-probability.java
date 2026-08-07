class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<List<double[]>> ls = new ArrayList<>();

        for(int i = 0; i < n; i++){
            ls.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            ls.get(u).add(new double[]{v, prob});
            ls.get(v).add(new double[]{u, prob});

        }

        double[] dist = new double[n];

        Arrays.fill(dist, 0.0);

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b[1], a[1]);
        });

        pq.add(new double[]{(double)start_node, 1});
        dist[start_node] = 1.0;

        while(!pq.isEmpty()){

            double[] curr = pq.poll();

            double node = curr[0];
            double distance = curr[1];

            if(distance < dist[(int)node]) continue;

            for(double[] arr : ls.get((int)node)){

                double neighbor = arr[0];
                double dis = arr[1];

                if(distance * dis > dist[(int)neighbor]){
                    dist[(int)neighbor] = distance * dis;
                    pq.add(new double[]{neighbor, dist[(int)neighbor]});
                }
            }
        }

        if(dist[end_node] == 0.0) return 0;

        return dist[end_node];

        
    }
}