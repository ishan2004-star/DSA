class Solution {
    Boolean dp[][];

    public String longestPalindrome(String s) {

        int n = s.length();

        dp = new Boolean[n][n];
        
        return help(s, 0);
    }

    public String help(String s, int index){

        if(index == s.length()) return "";

        String max = "";

        for(int i = index; i < s.length(); i++){
            
            if(check(index, i, s) && (i - index + 1) > max.length()){
                max = s.substring(index, i + 1);
            }
        }

        String res = help(s, index + 1);

        if(max.length() > res.length()){
            return max;
        }
        else{
            return res;
        }
    }

    public boolean check(int i, int j, String s){

        if(i > j) return true;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) != s.charAt(j)) return false;

        return dp[i][j] = check(i + 1, j - 1, s);


    }
}