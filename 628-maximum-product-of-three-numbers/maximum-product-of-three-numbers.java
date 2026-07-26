class Solution {
    public int maximumProduct(int[] nums) {
        
        Arrays.sort(nums);
        int len=nums.length-1;
        if(nums[0]>0){return nums[len]*nums[len-1]*nums[len-2];}
        
        if(nums[0]<0 && nums[len]<0){
            return nums[len]*nums[len-1]*nums[len-2];
        }

        if(nums[0]<0 && nums[len]>0){
            return Math.max(nums[len]*nums[len-1]*nums[len-2],nums[0]*nums[1]*nums[len]);
        }
        return nums[len]*nums[len-1]*nums[len-2];
    }
}