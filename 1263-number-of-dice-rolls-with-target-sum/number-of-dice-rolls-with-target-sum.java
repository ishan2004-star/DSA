class Solution {
    Integer[][] dp;
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {

        int[][] table = new int[n + 1][k + 1];

        dp = new Integer[n + 1][target + 1];

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                table[i][j] = j;
            }
        }

        return help(table, target, 1);
    }

    public int help(int table[][], int target, int index) {

        if(target < 0) return 0;
        if(target == 0 && index == table.length) return 1;
        if(index == table.length) return 0;

        if(dp[index][target] != null) return dp[index][target];

        int ways = 0;

        for(int i = 1; i < table[0].length; i++){

            ways = (ways + help(table, target - table[index][i], index + 1))%mod;
        }

        return dp[index][target] = ways;
        
    }
}