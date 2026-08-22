class Solution {
    public boolean checkDivisibility(int n) {
        
        int s1 = 0;
        int s2 = 1;

        for(char c : String.valueOf(n).toCharArray()){
            s1 += c - '0';
            s2 *= c - '0';
        }

        return n % (s1 + s2) == 0;

    }
}