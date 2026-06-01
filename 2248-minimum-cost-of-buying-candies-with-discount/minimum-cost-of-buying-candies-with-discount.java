class Solution {
    public int minimumCost(int[] cost) {

        int n = cost.length;
        
        Arrays.sort(cost);

        int count = 1;

        int minimum_cost = 0;

        for(int i = n - 1 ; i >= 0; i--){

            if(count == 3){ count = 1; continue;};

            minimum_cost += cost[i];
            count++;
            
        }

        return minimum_cost;
    }
}