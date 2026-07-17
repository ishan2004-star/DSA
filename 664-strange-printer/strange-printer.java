class Solution {
    private Integer[][] memo;
    private String s;

    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        this.s = s;
        this.memo = new Integer[n][n];

        return solve(0, n - 1);
    }

    private int solve(int i, int j) {

        if (i > j) return 0;


        if (i == j) return 1;

        if (memo[i][j] != null) return memo[i][j];

        int best = solve(i, j - 1) + 1;

        for (int k = i; k < j; k++) {
            if (s.charAt(k) == s.charAt(j)) {
                int candidate = solve(i, k) + solve(k + 1, j - 1);
                best = Math.min(best, candidate);
            }
        }

        memo[i][j] = best;
        return best;
    }
}