class Solution {
    Integer dp[][];
    public int splitArray(int[] nums, int k) {

        dp = new Integer[k + 1][nums.length + 1];
        return help(nums,k, 0);
    }
 
    public int help(int[] nums, int k, int index){

        if(index == nums.length){
            if(k > 1) return Integer.MIN_VALUE;
        }

        if(dp[k][index] != null) return dp[k][index];

        if(k == 1){
            int sum = 0;

            for(int i = index; i < nums.length; i++){
                sum += nums[i];
            }

            return dp[k][index] = sum;
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i = index; i < nums.length; i++){
            sum += nums[i];

            min = Math.min(min, Math.max(sum, help(nums, k - 1, i + 1)));
        }

        return dp[k][index] = min;
    }
}