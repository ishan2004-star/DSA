class Solution {
    Double dp[][];
    public double largestSumOfAverages(int[] nums, int k) {

        dp = new Double[nums.length][k + 1];

        return help(nums, k, 0);
    }

    public double help(int nums[], int k, int index) {

        if (index == nums.length) {
            return k == 0 ? 0 : Double.NEGATIVE_INFINITY;
        }

        if (k == 1) {
            int sum = 0;
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
            }
            return dp[index][k] = (double) sum / (nums.length - index);
        }

        if(dp[index][k] != null) return dp[index][k];

        double max = 0;
        int sum = 0;

        for (int i = index; i < nums.length; i++) {

            sum += nums[i];
            double avg = (double) sum / (i - index + 1);

            max = Math.max(max, avg + help(nums, k - 1, i + 1));
        }

        return dp[index][k] = max;
    }
}