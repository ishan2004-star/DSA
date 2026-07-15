class Solution {
    Integer dp[][];
    public int getMoneyAmount(int n) {

        dp = new Integer[n + 1][n + 1];
        
        return help(1, n);
    }

    public int help(int i, int j){

        if(i >= j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int min = Integer.MAX_VALUE/2;

        for(int k = i; k < j; k++){
            min = Math.min(min,k + Math.max(help(i,k - 1), help(k + 1, j)));
        }

        return dp[i][j] = min;
    }
}