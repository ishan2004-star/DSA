class Solution {
    public int gcdOfOddEvenSums(int n) {
        
        int odd = 0;
        int k = 1;

        for(int i = 0; i < n; i++){
            odd += k;
            k += 2;
        }

        k = 2;
        int even = 0;

        for(int i = 0; i < n; i++){
            even += k;
            k += 2;
        }

        for(int i = Math.min(even, odd); i >= 1; i--){
            if(odd%i ==  0 && even%i == 0) return  i; 
        }

        return even;
    }
}