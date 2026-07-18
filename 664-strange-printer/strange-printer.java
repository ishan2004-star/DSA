class Solution {
    Integer dp[][];
    public int strangePrinter(String s) {

        dp = new Integer[s.length()][s.length()];
        
        return help(s, 0, s.length() - 1);
    }

    public int help(String s, int i, int j){

        if(i == j) return 1;

        if(dp[i][j] != null) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k = i; k < j; k++){
            min = Math.min(min, help(s, i, k) + help(s, k + 1, j));
        }

        return dp[i][j] = (s.charAt(i) == s.charAt(j))? min - 1:min;
    }
}