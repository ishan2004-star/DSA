class Solution {

    HashSet<String> hs;
    List<String>[] dp;

    public List<String> wordBreak(String s, List<String> wordDict) {

        hs = new HashSet<>(wordDict);
        dp = new ArrayList[s.length() + 1];

        return help(s, 0);
    }

    public List<String> help(String s, int index) {

        if (dp[index] != null)
            return dp[index];

        List<String> ans = new ArrayList<>();

        if (index == s.length()) {
            ans.add("");
            return dp[index] = ans;
        }

        for (int i = index; i < s.length(); i++) {

            String word = s.substring(index, i + 1);

            if (hs.contains(word)) {

                List<String> suffix = help(s, i + 1);

                for (String str : suffix) {

                    if (str.equals(""))
                        ans.add(word);
                    else
                        ans.add(word + " " + str);
                }
            }
        }

        return dp[index] = ans;
    }
}