class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        Arrays.sort(costs);

        for(int i = 0; i < costs.length; i++){
            
            if(coins <= 0) return i;

            if(costs[i] > coins) return i;

            coins -= costs[i];
        }

        return costs.length;
    }
}