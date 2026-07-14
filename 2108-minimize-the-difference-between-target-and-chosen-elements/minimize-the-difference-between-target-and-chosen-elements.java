class Solution {
    Integer[][] dp;
    public int minimizeTheDifference(int[][] mat, int target) {

        dp = new Integer[mat.length][mat.length * 70 + 1];
        
        return help(mat, target, 0, 0);
    }

    public int help(int mat[][], int target, int sum, int row){

        if(row == mat.length){
            return Math.abs(sum - target);
        }

        if(dp[row][sum] != null) return dp[row][sum];

        int ans = Integer.MAX_VALUE;

        for(int col = 0; col < mat[0].length; col++){
            ans = Math.min(ans, help(mat,target,sum+mat[row][col],row + 1));
        }

        return dp[row][sum] = ans;
    }
}