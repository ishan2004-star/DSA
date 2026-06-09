class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum%2 != 0) return false;

        int[][] dp = new int[nums.length + 1][sum + 1];

        int k = sum/2;

        for(int i = 1; i < nums.length + 1; i++){

            for(int j = 1; j < sum + 1; j++){

                if(nums[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], nums[i - 1] + dp[i - 1][j - nums[i - 1]]);
                }
  
                if(dp[i][j] == k) return true;
            }
        }

        return false;
    }
}