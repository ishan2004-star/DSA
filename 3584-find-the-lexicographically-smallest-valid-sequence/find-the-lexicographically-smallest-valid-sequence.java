class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];
        Arrays.fill(last, -1);

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;

                if (j < 0) {
                    break;
                }
            }
        }

        boolean change = false;
        j = 0;

        int[] res = new int[m];
        int k = 0;

        for (int i = 0; i < n; i++) {

            if (j == m) {
                break;
            }

            if (word1.charAt(i) == word2.charAt(j)) {
                res[k++] = i;
                j++;
            }
            else if (!change && (j == m - 1 || last[j + 1] > i)) {
                change = true;
                res[k++] = i;
                j++;
            }
        }

        if (k == m) {
            return res;
        }

        return new int[0];
    }
}