class Solution {
    public int reverseDegree(String s) {
        int reverse = 0;

        for (int index = 0; index < s.length(); index++) {
            int temp = 26 - (s.charAt(index) - 'a');

            reverse += temp * (index + 1);
        }

        return reverse;
    }
}