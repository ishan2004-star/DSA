class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int size = strs.length;
        
        int[][][] dp = new int[size + 1][m + 1][n + 1];

        for(int index = strs.length - 1; index >= 0; index--){

            int zeros = 0;
            int ones = 0;

            for(char ch : strs[index].toCharArray()){
                if(ch == '0'){
                    zeros++;
                }
                else{
                    ones++;
                }
            }

            for(int i = 0; i <= m; i++){
                for(int j = 0; j <= n; j++){

                    int take = -1;

                    if(i >= zeros && j >= ones){
                        take = 1 + dp[index + 1][i - zeros][j - ones];
                    }

                    int skip = dp[index + 1][i][j];

                    dp[index][i][j] = Math.max(skip, take);
                }
            }
        }

        return dp[0][m][n];
    }
}