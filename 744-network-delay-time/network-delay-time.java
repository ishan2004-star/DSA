class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> ls = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            ls.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            ls.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });


        dist[k] = 0;
        pq.add(new int[]{k, 0});


        while(!pq.isEmpty()){

            int[] poll = pq.poll();

            int node = poll[0];
            int distance = poll[1];

            if(distance > dist[node])continue;

            for(int[] arr : ls.get(node)){
                int neighbor = arr[0];
                int weight = arr[1];

                if(distance + weight < dist[neighbor]){
                    dist[neighbor] = distance + weight;
                    pq.add(new int[]{neighbor, dist[neighbor]});
                }
            }
        }

        int min = 0;

        for(int i = 1; i < dist.length; i++){
            min = Math.max(min, dist[i]);
        }

        if(min == Integer.MAX_VALUE) return -1;

        return min;

    }
}