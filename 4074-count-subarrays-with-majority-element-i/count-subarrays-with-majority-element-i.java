class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int count = 0;
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j >= 0; j--){

                if(nums[j] == target) count++;

                if(2 * count > (i - j + 1)) result++;
            }
            count = 0;
        }

        return result;
    }
}