class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        int pick = 0;
        int not_pick = 0;
        int res = 0;

        for(int i = n - 1; i >= 0; i--){

            res = Math.max(nums[i] + pick, not_pick);

            pick = not_pick;
            not_pick = res;

        }
        
        return res;
    }
 

}