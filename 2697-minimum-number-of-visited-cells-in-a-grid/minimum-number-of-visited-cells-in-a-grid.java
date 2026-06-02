class Solution {

    public int minimumVisitedCells(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer>[] rows = new TreeSet[m];
        TreeSet<Integer>[] cols = new TreeSet[n];

        for(int i = 0; i < m; i++){
            rows[i] = new TreeSet<>();

            for(int j = 0; j < n; j++){
                rows[i].add(j);
            }
        }

        for(int j = 0; j < n; j++){
            cols[j] = new TreeSet<>();

            for(int i = 0; i < m; i++){
                cols[j].add(i);
            }
        }

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(0, 0));

        rows[0].remove(0);
        cols[0].remove(0);

        int count = 1;

        while(!q.isEmpty()){

            int size = q.size();

            for(int s = 0; s < size; s++){

                pair poll = q.poll();

                int i = poll.x;
                int j = poll.y;

                if(i == m - 1 && j == n - 1){
                    return count;
                }

                int maxCol = Math.min(n - 1, j + grid[i][j]);

                Integer c = rows[i].ceiling(j + 1);

                while(c != null && c <= maxCol){

                    q.add(new pair(i, c));

                    rows[i].remove(c);
                    cols[c].remove(i);

                    c = rows[i].ceiling(c);
                }

                int maxRow = Math.min(m - 1, i + grid[i][j]);

                Integer r = cols[j].ceiling(i + 1);

                while(r != null && r <= maxRow){

                    q.add(new pair(r, j));

                    cols[j].remove(r);
                    rows[r].remove(j);

                    r = cols[j].ceiling(r);
                }
            }

            count++;
        }

        return -1;
    }
}

class pair{

    int x;
    int y;

    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}