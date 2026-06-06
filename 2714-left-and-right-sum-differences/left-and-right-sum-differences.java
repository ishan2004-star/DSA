class Solution {
    public int[] leftRightDifference(int[] nums) {
        if(nums.length==1){return new int[]{0};}
        int arr[]=new int[nums.length];int sum=0;int pro=nums[0];

        for(int i=0;i<nums.length;i++){sum+=nums[i];}
        arr[0]=Math.abs(sum-nums[0]);sum-=nums[0];
        for(int j=1;j<nums.length;j++){
            sum-=nums[j];
            arr[j]=Math.abs(sum-pro);
            pro+=nums[j];
        }
        return arr;
    }
}