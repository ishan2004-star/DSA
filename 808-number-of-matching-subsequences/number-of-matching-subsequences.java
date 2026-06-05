class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int n = s.length();
        int count = 0;

        int[][] dp = new int[n + 1][26];

        for(int i = 0; i < 26; i++){
            dp[n][i] = -1;
        }

        for(int i = n - 1; i >= 0; i--){
 
            for(int j = 0; j < 26; j++){
                dp[i][j] = dp[i + 1][j];
            }
            dp[i][s.charAt(i) - 'a'] = i; 
        }


        for(String word : words){

            int pos = 0;
            boolean flag = true;

            if(word.length() > s.length()) continue;

            for(char ch : word.toCharArray()){

                if(dp[pos][ch - 'a'] == -1){
                    flag = false;
                    break;
                }

                pos = dp[pos][ch - 'a'] + 1;
            }

            if(flag) count++;
        }

        return count;
    }
}