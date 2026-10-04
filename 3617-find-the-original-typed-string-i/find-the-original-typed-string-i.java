
class Solution {
    public int possibleStringCount(String word) {
        int[] freq = new int[26];
        int count = 1;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (i == 0 || c != word.charAt(i - 1)) {
                freq[c - 'a'] = 1;
            } else {
                freq[c - 'a']++;
            }

            if (i == word.length() - 1 || c != word.charAt(i + 1)) {
                count += freq[c - 'a'] - 1;
                freq[c - 'a'] = 0;
            }
        }

        return count;
    }
}
