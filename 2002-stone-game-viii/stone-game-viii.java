class Solution {
    int prefix[];
    public int stoneGameVIII(int[] stones) {
        
        int n = stones.length;

        prefix = new int[n];
        prefix[0] = stones[0];

        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i - 1] + stones[i];
        }

        return stone(1, n);

    }

    public int stone(int i, int n){
        if(i == n - 1){
            return prefix[ n - 1 ];
        }

        int take = prefix[i];
        int skip = stone(i + 1, n);

        return Math.max(skip, take - skip);
    }
}