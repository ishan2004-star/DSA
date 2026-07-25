class Solution {
    public int maxProduct(int n) {
        
        String s = String.valueOf(n);

        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            int num1 = s.charAt(i) - '0';
            for(int j = i + 1; j < s.length(); j++){

                int num2 = s.charAt(j) - '0';

                ans = Math.max(ans, num1 * num2);
            }
        }

        return ans;
    }
}