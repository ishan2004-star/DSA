class Solution {
    int min = Integer.MIN_VALUE;
    pair dp[][];
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;

        dp = new pair[n][2];
        
        pair result = help(stoneValue, 0, 1, 0);

        if(result.A_score > result.B_score){
            return "Alice";
        }
        else if(result.A_score < result.B_score){
            return "Bob";
        }
        else{
            return "Tie";
        }
    }

    public pair help(int nums[], int index, int turnA, int turnB){

        if(index < nums.length){
            if(turnA == 1 && dp[index][0] != null){
                return dp[index][0];
            }

            if(turnB == 1 && dp[index][1] != null){
                return dp[index][1];
            }
        }

        pair p = new pair(min, min);

        int sum = 0;

        for(int i = index; i < index + 3 && i < nums.length; i++){
            sum += nums[i];
            
            if(turnA == 1){
                pair res = help(nums, i + 1, 0, 1);

                if(sum + res.A_score > p.A_score){
                    p.A_score = sum + res.A_score;
                    p.B_score = res.B_score;
                }

            }
            else{
                pair res = help(nums, i + 1, 1, 0);

                if(sum + res.B_score > p.B_score){
                    p.B_score = sum + res.B_score;
                    p.A_score = res.A_score;
                }
            }
        }

        if(p.A_score == min) p.A_score = 0;
        if(p.B_score == min) p.B_score = 0;

        if(index < nums.length && turnA == 1){
            dp[index][0] = p;
        }
        if(index < nums.length && turnB == 1){
            dp[index][1] = p;
        }

        return p;
    }
}

class pair{

    int A_score;
    int B_score;

    pair(int A_score, int B_score){
        this.A_score = A_score;
        this.B_score = B_score;
    }
}