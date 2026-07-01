class Solution {
    Integer dp[];
    public int minCostClimbingStairs(int[] cost) {

        dp = new Integer[cost.length];
        
        return Math.min(help(cost,0), help(cost, 1));
    }

    public int help(int[] nums, int index){

        if(index >= nums.length) return 0;

        if(dp[index] != null) return dp[index];

        return dp[index] = nums[index] + Math.min(help(nums, index + 1),help(nums, index + 2));
    }
}