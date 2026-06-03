class Solution {

    Integer[][] dp;

    public int minDistance(String word1, String word2) {

        dp = new Integer[word1.length()][word2.length()];
        
        return edit(word1, word2, 0, 0);
    }

    public int edit(String s, String t, int i, int j){

        int n = s.length();
        int m = t.length();

        if(i == n) return m - j;

        if(j == m) return n - i;

        if(dp[i][j] != null) return dp[i][j];

        int delete = 0;
        int insert = 0;
        int replace = 0;

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = edit(s, t, i + 1, j + 1);
        }
        else{
            delete = 1 + edit(s, t, i + 1, j);
            insert = 1 + edit(s, t, i, j + 1);
            replace = 1 + edit(s, t, i + 1, j + 1);
        }

        return dp[i][j] = Math.min( delete, Math.min(insert,replace));

    }
}