class Solution {
    public int numSquares(int n) {

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;

        int num = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int j = 0; j < size; j++) {
                int poll = q.poll();
                if (poll == 0)
                    return num;

                for (int i = 1; i * i <= poll; i++) {
                    int next = poll - i * i;

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            num++;
        }

        return num;
    }
}