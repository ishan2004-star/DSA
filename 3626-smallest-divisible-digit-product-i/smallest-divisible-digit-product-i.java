class Solution {
    public int smallestNumber(int n, int t) {
        
        while(true){

            String s = Integer.toString(n);

            int product = 1;

            for(int i = 0; i < s.length(); i++){
                product *= (s.charAt(i) - '0');
            }

            if(product % t == 0) return n;
            else{
                n++;
                product = 1;
            }
        }

    }
}