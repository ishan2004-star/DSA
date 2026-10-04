
class Solution {
    public String[] findWords(String[] words) {
        int[] row = new int[26];

        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";

        for (char c : r1.toCharArray()) row[c - 'a'] = 1;
        for (char c : r2.toCharArray()) row[c - 'a'] = 2;
        for (char c : r3.toCharArray()) row[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String s = word.toLowerCase();
            int target = row[s.charAt(0) - 'a'];
            boolean valid = true;

            for (char c : s.toCharArray()) {
                if (row[c - 'a'] != target) {
                    valid = false;
                    break;
                }
            }

            if (valid) result.add(word);
        }

        return result.toArray(new String[0]);
    }
}
