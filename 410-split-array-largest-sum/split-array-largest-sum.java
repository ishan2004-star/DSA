class Solution {
    public int splitArray(int[] nums, int k) {
        
        long sum = 0;
        int max = 0;
        
        for(int i = 0; i < nums.length; i++) {sum += nums[i];max = Math.max(max, nums[i]);}

        return search((long)max, sum, nums, k);
    }

    public int search(long left, long right, int[] nums, int k){

        while(left <= right){

            long mid = left + (right - left)/2;

            if(canDo(nums, mid, k)){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }

        }

        return (int)left;
    }

    public boolean canDo(int[] nums, long mid, int k){

        long container = 0;
        int count = 1;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] + container > mid){
                count++;
                if(count > k) return false;
                container = 0;
            }

            container += nums[i];
        }

        return count <= k;
    }
}