class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        int dp[] = new int[n + 2];

        Arrays.fill(dp, 0);


        for(int i = n - 1; i >= 0; i--){
            int pick = nums[i] + dp[i + 2];
            int not_pick = dp[i + 1];

            dp[i] = Math.max(pick, not_pick);

        }
        
        return dp[0];
    }
 
    public int help(int nums[], int index, int[] dp){

        if(index >= nums.length) return dp[index] = 0;

        if(dp[index] != -1) return dp[index];

        int pick = -1;
        int not_pick = -1;

        pick = nums[index] + help(nums, index + 2, dp);
        not_pick = help(nums, index + 1, dp);

        return dp[index] = Math.max(pick, not_pick);
    }
}