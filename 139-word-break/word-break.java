class Solution {
    HashSet<String> hs;
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {

        hs = new HashSet<>();
        dp = new Boolean[s.length()];

        for(String st : wordDict){
            hs.add(st);
        }

        return help(s, 0);
        
    }

    public boolean help(String s, int index){

        if(index == s.length()) return true;

        if(dp[index] != null) return dp[index];

        for(int i = index; i < s.length(); i++){

            if(hs.contains(s.substring(index,i + 1))){
                if(help(s, i + 1)) return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
}