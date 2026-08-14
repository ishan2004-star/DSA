class Solution {
    public int maximumLengthSubstring(String s) {

        int i = 0;
        int j = 0;
        int max = 0;

        HashMap<Character, Integer> hs = new HashMap<>();

        while (j < s.length()) {

            char c = s.charAt(j);

            hs.put(c, hs.getOrDefault(c, 0) + 1);

            while (hs.get(c) > 2) {
                char left = s.charAt(i);
                hs.put(left, hs.get(left) - 1);
                i++;
            }

            max = Math.max(max, j - i + 1);

            j++;

        }

        return max;
    }
}