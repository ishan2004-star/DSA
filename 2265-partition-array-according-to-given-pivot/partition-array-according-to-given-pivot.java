class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int[] result=new int[nums.length];
        int index=0;int count=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                result[index]=nums[i];
                index++;
            }
            if(nums[i]==pivot)count++;
        }
        for(int p=0;p<count;p++){
            result[index]=pivot;
            index++;
        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]>pivot){
                result[index]=nums[j];
                index++;
            }
        }
        return result;
    }
}