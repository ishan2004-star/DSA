class Solution {
    Integer dp[][][];
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        dp = new Integer[nums.length][2][2];

        return help(nums, firstLen, secondLen, 0);
    }

    public int help(int[] nums, int firstlen, int secondlen, int index){

        if(index >= nums.length) return 0;

        if(firstlen == 0 && secondlen == 0) return 0;

        int len1 = firstlen > 0? 0:1;
        int len2 = secondlen > 0? 0:1;

        if(dp[index][len1][len2] != null) return dp[index][len1][len2];


         int pick_first = 0;

        // pick
        if(firstlen > 0 && index + firstlen <= nums.length){

            for(int i = index; i < index + firstlen; i++){
                pick_first += nums[i];
            }

            pick_first = pick_first + help(nums, 0, secondlen, index + firstlen);
        }

        int pick_second = 0;

        if(secondlen > 0 && index + secondlen <= nums.length){

            for(int i = index; i < index + secondlen; i++){
                pick_second += nums[i];
            }

            pick_second = pick_second + help(nums, firstlen, 0, index + secondlen);
        }

        // skip
        int skip = help(nums, firstlen, secondlen, index + 1);

        return dp[index][len1][len2] = Math.max(skip, Math.max(pick_first, pick_second));
    }
}