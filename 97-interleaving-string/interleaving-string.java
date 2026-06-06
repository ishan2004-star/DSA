class Solution {
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        dp = new Boolean[s1.length()][s2.length()];

        return leave(s1, s2, s3, 0, 0);
    }

    public boolean leave(String s1, String s2, String s3,int i, int j) {

        if (i == s1.length() && j == s2.length())
            return true;
        
        if(i < s1.length() && j < s2.length() && dp[i][j] != null) return dp[i][j];

        int k = i + j;

        boolean fromS1 = false;
        boolean fromS2 = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            fromS1 = leave(s1, s2, s3, i + 1, j);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            fromS2 = leave(s1, s2, s3, i, j + 1);
        }

        if(i < s1.length() && j < s2.length()){
            dp[i][j] = fromS1 || fromS2;
        }

        return fromS1 || fromS2;
    }
}