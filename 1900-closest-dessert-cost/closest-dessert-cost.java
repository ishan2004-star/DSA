class Solution {
    Integer dp[][];

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

        int ans = Integer.MAX_VALUE;

        int maxSum = 0;

        for (int base : baseCosts)
            maxSum = Math.max(maxSum, base);

        for (int topping : toppingCosts)
            maxSum += 2 * topping;

        dp = new Integer[toppingCosts.length][maxSum + 1];

        for (int i = 0; i < baseCosts.length; i++) {
            int curr = help(toppingCosts, target, 0, baseCosts[i]);

            if (Math.abs(curr - target) < Math.abs(ans - target) ||
                    (Math.abs(curr - target) == Math.abs(ans - target) && curr < ans)) {
                ans = curr;
            }
        }

        return ans;
    }

    public int help(int nums[], int target, int index, int sum) {

        if (index == nums.length) {
            return sum;
        }

        if (dp[index][sum] != null)
            return dp[index][sum];

        int one = help(nums, target, index + 1, sum + nums[index]);
        int two = help(nums, target, index + 1, sum + nums[index] * 2);
        int skip = help(nums, target, index + 1, sum);

        int ele = one;
        int max = Math.abs(one - target);

        if (Math.abs(two - target) < max ||
                (Math.abs(two - target) == max && two < ele)) {
            ele = two;
            max = Math.abs(two - target);
        }

        if (Math.abs(skip - target) < max ||
                (Math.abs(skip - target) == max && skip < ele)) {
            ele = skip;
        }

        return dp[index][sum] = ele;
    }
}