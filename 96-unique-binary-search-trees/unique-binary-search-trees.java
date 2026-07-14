class Solution {
    Integer dp[][];

    public int numTrees(int n) {

        dp = new Integer[n + 1][n + 1];

        return partition(1,n);
    }

    public int partition(int start, int end){

        if(start >= end) return 1;

        int ans = 0;

        if(dp[start][end] != null) return dp[start][end];

        for(int i = start; i <= end; i++){

            int left = partition(start, i - 1);
            int right = partition(i + 1, end);

            ans += left * right;
        }

        return dp[start][end] = ans;
    }
}