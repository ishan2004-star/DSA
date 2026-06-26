class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;
        
        int sum_count[] = new int[2*n + 2];
        int cumm_count[] = new int[2*n + 2];

        int index = n + 1;

        sum_count[index] = 1;
        cumm_count[index] = 1;

        long result = 0;

        for(int num : nums){
            if(num == target) index++;
            else index--;

            sum_count[index]++;

            result += cumm_count[index - 1];

            cumm_count[index] = cumm_count[index - 1] + sum_count[index];

        }

        return result;

    }
}