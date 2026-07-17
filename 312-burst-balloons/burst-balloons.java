class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {

        dp = new Integer[nums.length + 3][nums.length + 3];
        
        return help(nums, -1, nums.length);
    }

    public int help(int nums[], int start, int end){

        if (start + 1 == end) return 0;

        if(dp[start + 1][end + 1] != null) return dp[start + 1][end + 1];

        int max = 0;

        for(int i = start + 1; i < end; i++){

            int call = help(nums, start, i) + help(nums, i, end);

            int prev = 1;
            int next = 1;

            prev = (start == -1) ? 1 : nums[start];
            next = (end == nums.length) ? 1 : nums[end];

            int calculate = nums[i]*prev*next;
 
            max = Math.max(max, calculate + call);
        }

        return dp[start + 1][end + 1] = max;
    }
}