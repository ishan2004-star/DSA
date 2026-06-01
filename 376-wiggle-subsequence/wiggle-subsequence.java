class Solution {
    Integer dp[][][];
    public int wiggleMaxLength(int[] nums) {
        
        int max = 0;

        int n = nums.length;

        dp = new Integer[n][n][2]; 

        for(int i = 0; i < nums.length - 1; i++){

            if(nums[i + 1] - nums[i] > 0){
                max = Math.max(max, wiggle(nums, i, i + 1, 0));
            }

            if(nums[i + 1] - nums[i] < 0){
                max = Math.max(max, wiggle(nums, i, i + 1, 1));
            }
        }

        return max + 1;

    }

    public int wiggle(int[] nums, int prev, int curr, int sign){

        if(nums.length == curr) return 0;

        if(dp[curr][prev][sign] != null) return dp[curr][prev][sign];

        int plus = 0;
        int minus = 0;

        if(sign == 1 && nums[curr] - nums[prev] < 0){
            plus = 1 + wiggle(nums, curr, curr + 1, 0);
        }
        else if(sign == 0 && nums[curr] - nums[prev] > 0){
            minus = 1 + wiggle(nums, curr, curr + 1, 1);
        }
        
        int skip = wiggle(nums, prev, curr + 1, sign);

        return dp[curr][prev][sign] = Math.max(skip, Math.max(plus, minus));
    }
}