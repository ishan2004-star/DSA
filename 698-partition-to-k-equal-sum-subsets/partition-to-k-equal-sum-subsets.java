class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        if (nums[0] > target) {
            return false;
        }

        return solve(nums, used, k, 0, 0, target);
    }

    private boolean solve(int[] nums, boolean[] used, int bucketCount, int bucketSum, int start, int target) {

        if (bucketCount == 1) {
            return true;
        }

        if (bucketSum == target) {
            return solve(nums, used, bucketCount - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (bucketSum + nums[i] > target) {
                continue;
            }

            used[i] = true;

            if (solve(nums, used, bucketCount, bucketSum + nums[i], i + 1, target)) {
                return true;
            }

            used[i] = false;

            if (bucketSum == 0) {
                break;
            }

            if (bucketSum + nums[i] == target) {
                break;
            }
        }

        return false;
    }
}