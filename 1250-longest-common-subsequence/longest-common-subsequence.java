class Solution {
    Integer dp[][];
    public int longestCommonSubsequence(String text1, String text2) {

        dp = new Integer[text1.length()][text2.length()];
        
        return lcs(text1, text2, 0, 0);
    }

    public int lcs(String text1, String text2, int i, int j){

        if(text1.length() == i || text2.length() == j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int match1 = 0;

        if(text1.charAt(i) == text2.charAt(j)){
            match1 = 1 + lcs(text1, text2, i + 1, j + 1);
        }

        int match2 = lcs(text1, text2, i, j + 1);
        int match3 = lcs(text1, text2, i + 1, j);

        return dp[i][j] = Math.max(match1, Math.max(match2, match3));
    }
}