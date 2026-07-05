class Solution {
    Long[][] dpMax;
    Long[][] dpCount;
    int n;
    long mod = 1000000007;
    final long UNREACHABLE = Long.MIN_VALUE / 2; 

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        dpMax = new Long[n][n];
        dpCount = new Long[n][n];

        long target = build(board, n - 1, n - 1);

        if (target < 0) {
            return new int[]{0, 0};
        }

        long ways = count(board, n - 1, n - 1);
        return new int[]{(int) target, (int) ways};
    }


    public long build(List<String> board, int i, int j) {
        if (i < 0 || j < 0) return UNREACHABLE;
        if (board.get(i).charAt(j) == 'X') return UNREACHABLE;
        if (i == 0 && j == 0) return 0;

        if (dpMax[i][j] != null) return dpMax[i][j];

        long left = build(board, i, j - 1);
        long up   = build(board, i - 1, j);
        long diag = build(board, i - 1, j - 1);

        long best = Math.max(left, Math.max(up, diag));

        if (best == UNREACHABLE) {
            return dpMax[i][j] = UNREACHABLE;
        }

        long digit = (board.get(i).charAt(j) == 'S' || board.get(i).charAt(j) == 'E')
                     ? 0 : (board.get(i).charAt(j) - '0');

        return dpMax[i][j] = best + digit;
    }


    public long count(List<String> board, int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (board.get(i).charAt(j) == 'X') return 0;

        if (dpCount[i][j] != null) return dpCount[i][j];

        long here = build(board, i, j);
        if (here == UNREACHABLE) return dpCount[i][j] = 0L;

        long digit = (board.get(i).charAt(j) == 'S' || board.get(i).charAt(j) == 'E')
                     ? 0 : (board.get(i).charAt(j) - '0');

        long ways = 0;
        int[] di = {0, -1, -1};
        int[] dj = {-1, 0, -1};

        for (int k = 0; k < 3; k++) {
            int pi = i + di[k], pj = j + dj[k];
            if (pi < 0 || pj < 0) continue;
            long pred = build(board, pi, pj);
            if (pred == UNREACHABLE) continue;
            if (pred + digit == here) {
                ways = (ways + count(board, pi, pj)) % mod;
            }
        }

        return dpCount[i][j] = ways;
    }
}