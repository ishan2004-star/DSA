class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<int[]>> ls = new ArrayList<>();

        int[][] dist = new int[n][k + 2];

        for(int i = 0; i < dist.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++){
            ls.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            ls.get(u).add(new int[]{v, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[]{src, 0, k + 1});
        dist[src][k + 1] = 0;

        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();

            int node = curr[0];
            int cost = curr[1];
            int left = curr[2];

            if(left == 0) continue;

            if(cost > dist[node][left]) continue;

            for(int[] arr : ls.get(node)){
                int neighbor = arr[0];
                int c = arr[1];

                if(cost + c < dist[neighbor][left - 1]){
                    dist[neighbor][left - 1] = cost + c;
                    pq.add(new int[]{neighbor, dist[neighbor][left - 1], left - 1});
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= k; i++){
            min = Math.min(min, dist[dst][i]);
        }

        if(min == Integer.MAX_VALUE) return -1;

        return min;


        
    }
}