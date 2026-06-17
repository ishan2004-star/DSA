class Solution {
    Integer dp[][];
    public int minCost(int n, int[] cuts) {


        int nums[] = new int[cuts.length + 2];

        dp = new Integer[cuts.length + 2][cuts.length + 2];

        nums[0] = 0;

        for(int i = 1; i <= cuts.length; i++){
            nums[i] = cuts[i - 1];
        }

        nums[cuts.length + 1] = n;

        Arrays.sort(nums);
        
        return help(1, cuts.length, nums);
    }

    public int help(int i, int j, int[] nums){
        if(i > j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int min = (int)1e9;

        for(int index = i; index <= j; index++){

            int cut = nums[j + 1] - nums[i - 1] + help(i, index - 1, nums) + help(index + 1, j, nums);

            min = Math.min(cut, min); 
        }

        return dp[i][j] = min;
    }
}