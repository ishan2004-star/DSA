class Solution {
    public String findLongestWord(String s, List<String> dictionary) {

        int n = s.length();

        int dp[][] = new int[n + 1][26];

        for(int[] arr : dp) Arrays.fill(arr, -1);

        for(int i = n - 1; i >= 0; i--){

            for(int j = 0; j < 26; j++){
                dp[i][j] = dp[i + 1][j];
            }

            dp[i][s.charAt(i) - 'a'] = i;
        }

        String ans = "";


        for(String word : dictionary){

            int pos = 0;
            boolean flag = true;

            for(char c : word.toCharArray()){

                if(pos > n){
                    flag = false;
                    break;
                }

                int index = dp[pos][c - 'a'];

                if(index == -1){
                    flag = false;
                    break;
                }

                pos = index + 1;
            }

            if(flag){

                if(word.length() > ans.length()){
                    ans = word;
                }
                else if(word.length() == ans.length() && word.compareTo(ans) < 0){
                    ans = word;
                }
            }
        }

        return ans;
        
    }
}