class Solution {
    Integer dp[][];
    public int minScoreTriangulation(int[] values) {

        dp = new Integer[values.length][values.length];

        return help(values, 0, values.length - 1);
    }

    public int help(int nums[], int i, int j){

        if(j - i == 1) return dp[i][j] = 0;

        if(dp[i][j] != null) return dp[i][j];

        int min = Integer.MAX_VALUE;
        
        for(int index = i + 1; index < j; index++){
            int product = nums[index] * nums[i] * nums[j];

            int res1 = help(nums, i, index);
            int res2 = help(nums, index, j);

            min = Math.min(min, product + res1 + res2);
        }

        return dp[i][j] = min;
    }
}