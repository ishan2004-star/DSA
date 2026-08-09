class Solution {
    Integer dp[][][];
    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new Integer[2][n][2*n + 1];
        
        return solve(piles, 0, 1, 0);
    }

    public int solve(int piles[], int index, int m, int turn){

        if(index >= piles.length) return 0;

        if(dp[turn][index][m] != null) return dp[turn][index][m];

        int stones = 0;
        int result = 0;

        if(turn == 0){
            result = -1;
        }
        else{
            result = Integer.MAX_VALUE;
        }

        for(int x = 1; x <= 2*m && index + x - 1 < piles.length; x++){

            stones += piles[index + x - 1];

            if(turn == 0){
                result = Math.max(result, stones + solve(piles, index + x, Math.max(m, x), 1));
            }
            else{
                result = Math.min(result, solve(piles, index + x, Math.max(m, x), 0));
            }
        }

        return dp[turn][index][m] = result;
    }
}