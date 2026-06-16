class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
     
        int dp1[] = new int[amount + 1];
        int dp2[] = new int[amount + 1];

        int INF = (int)1e9;

        for(int j = 0; j <= amount; j++){
            dp1[j] = INF;
        }

        dp1[0] = 0;
                 
        for(int i = 0; i < n; i++){

            for(int j = 1; j <= amount; j++){

                dp2[j] = dp1[j];

                if(coins[i] <= j){
                    dp2[j] = Math.min(dp2[j], 1 + dp2[j - coins[i]]);
                }
            }
            int temp[] = dp1;
            dp1 = dp2;
            dp2 = temp;
        } 

        if(dp1[amount] == INF) return -1;
        return dp1[amount];
    }
}