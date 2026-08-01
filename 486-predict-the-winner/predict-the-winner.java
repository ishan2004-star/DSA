class Solution {
    public boolean predictTheWinner(int[] nums) {
        
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        int res = help(nums, 0, nums.length - 1);

        if(res >= sum - res) return true;

        return false;
    }

    public int help(int[] nums, int i, int j){

        if( i > j) return 0;

        int first_first = help(nums, i + 2, j);
        int first_last = help(nums, i + 1, j - 1);

        int max = nums[i] + Math.min(first_first, first_last);

        int last_first = help(nums, i + 1, j - 1);
        int last_last = help(nums, i, j - 2);

        max = Math.max(max, nums[j] + Math.min(last_first, last_last));

        return max; 
    }
} 
