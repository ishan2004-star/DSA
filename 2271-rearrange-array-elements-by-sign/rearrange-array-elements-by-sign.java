class Solution {
    public int[] rearrangeArray(int[] nums) {

        int N = nums.length;
        
        int[] pos = new int[N/2];
        int[] neg = new int[N/2];

        int p = 0;
        int n = 0;

        for(int i = 0; i < N; i++){
            if(nums[i] > 0){
                pos[p++] = nums[i];
            }
            else{
                neg[n++] = nums[i];
            }
        }

        p = 0;
        n = 0;

        for(int i = 0; i < N; i += 2){
            
            nums[i] = pos[p++];
        }

        for(int i = 1; i < N; i += 2){
            
            nums[i] = neg[n++];
        }

        return nums;
    }
}