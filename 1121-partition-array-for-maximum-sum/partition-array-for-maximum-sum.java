class Solution {
    Integer dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length];
        
        return help(arr, k, 0);

    }

    public int help(int arr[], int k, int index){

        if(index == arr.length) return 0;

        if(dp[index] != null) return dp[index];

        int max = 0;
        int answer = 0;

        for(int i = index; i < Math.min(arr.length, index + k); i++){

            max = Math.max(max, arr[i]);

            int length = i - index + 1;

            answer = Math.max(answer,max * length + help(arr, k, i + 1));

        }

        return dp[index] = answer;
    }
}