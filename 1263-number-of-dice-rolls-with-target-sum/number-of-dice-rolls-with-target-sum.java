class Solution {
    Integer[][] dp;
    int mod = 1000000007;
    int len;
    int K;
    public int numRollsToTarget(int n, int k, int target) {

        dp = new Integer[n + 1][target + 1];
        len = n + 1;
        K = k + 1;

        return help(target, 1);
    }

    public int help(int target, int index) {

        if(target < 0) return 0;
        if(target == 0 && index == len) return 1;
        if(index ==len) return 0;

        if(dp[index][target] != null) return dp[index][target];

        int ways = 0;

        for(int i = 1; i < K; i++){

            ways = (ways + help(target - i, index + 1))%mod;
        }

        return dp[index][target] = ways;
        
    }
}