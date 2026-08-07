class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        List<List<int[]>> ls = new ArrayList<>();

        int n = passingFees.length;

        for(int i = 0; i < passingFees.length; i++){
            ls.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];

            ls.get(u).add(new int[]{v, time});
            ls.get(v).add(new int[]{u, time});

        }

        int[][] dist = new int[n][maxTime + 1];

        for(int i = 0; i < dist.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
    return Integer.compare(a[2], b[2]);
});

        pq.add(new int[]{0, 0, passingFees[0]});
        dist[0][0] = passingFees[0];

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            int fees = curr[2];

            if(time > maxTime) continue;

            if(fees > dist[node][time]) continue;

            for(int[] arr : ls.get(node)){
                int neighbor = arr[0];
                int t = arr[1];

                int ti = time + t;

                if(ti > maxTime) continue;

                if(passingFees[neighbor] + fees < dist[neighbor][ti]){
                    dist[neighbor][ti] = passingFees[neighbor] + fees;

                    pq.add(new int[]{neighbor, ti, dist[neighbor][ti]});
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < maxTime + 1; i++){
            min = Math.min(min, dist[n - 1][i]);
        }

        if(min == Integer.MAX_VALUE) return -1;

        return min;
    }
}


