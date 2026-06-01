class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        
        int N = nums.length;
        
        int[] even = new int[N/2];
        int[] odd = new int[N/2];

        int p = 0;
        int n = 0;

        for(int i = 0; i < N; i++){
            if(nums[i] % 2 == 0){
                even[p++] = nums[i];
            }
            else{
                odd[n++] = nums[i];
            }
        }

        p = 0;
        n = 0;

        for(int i = 0; i < N; i += 2){
            
            nums[i] = even[p++];
        }

        for(int i = 1; i < N; i += 2){
            
            nums[i] = odd[n++];
        }

        return nums;
    }
}