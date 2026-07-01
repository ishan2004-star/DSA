class Solution {

    HashSet<String> hs;
    HashMap<String, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {

        hs = new HashSet<>();
        memo = new HashMap<>();

        for (String word : wordDict) {
            hs.add(word);
        }

        return help(s, 0, "");
    }

    public boolean help(String s, int index, String res) {

        if (index == s.length()) {
            return res.isEmpty();
        }

        String key = index + "#" + res;

        if (memo.containsKey(key))
            return memo.get(key);

        String r = res + s.charAt(index);

        boolean take = help(s, index + 1, r);

        boolean neww = false;
        if (hs.contains(r)) {
            neww = help(s, index + 1, "");
        }

        boolean ans = take || neww;

        memo.put(key, ans);

        return ans;
    }
}