class Solution {
    Boolean dp[][];
    public boolean canCross(int[] stones) {

        dp = new Boolean[stones.length][stones.length + 2];
        
        return frog_jump(stones,0,0);
    }

    public boolean frog_jump(int[] stones, int unit, int index){

        if(index == stones.length - 1) return true;

        if(dp[index][unit] != null) return dp[index][unit];

        int jump1 = unit + stones[index] + 1;
        int jump2 = unit + stones[index] - 1;
        int jump3 = unit + stones[index];

        for(int next = index + 1; next < stones.length; next++){

            if(stones[next] > jump1) break;

            if(stones[next] == jump1 && frog_jump(stones, unit + 1, next)){
                return dp[index][unit + 1] = true;
            }

            if(stones[next] == jump2 && frog_jump(stones, unit - 1, next)){
                return dp[index][unit - 1] = true;
            }

            if(stones[next] == jump3 && frog_jump(stones, unit, next)){
                return dp[index][unit] = true;
            }
        }

        return dp[index][unit] = false;
    }
}