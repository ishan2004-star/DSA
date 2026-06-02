class Solution {
    public int longestArithSeqLength(int[] nums) {

    
        int max = 0;
        int n = nums.length;
        int[][] dp = new int[n][1010];

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){

                int diff = nums[i] - nums[j];

                dp[i][diff + 500] = Math.max(dp[i][diff + 500], dp[j][diff + 500] + 1);

                max = Math.max(max, dp[i][diff + 500]);
            }
        }

        return max + 1;
    }
}