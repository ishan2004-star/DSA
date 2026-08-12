class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        int i = 0; 
        int j = 0;
        int max = 0;

        HashMap<Integer, Integer> hs = new HashMap<>();

        while(j < nums.length){

            hs.put(nums[j], hs.getOrDefault(nums[j], 0) + 1);

            while(hs.get(nums[j]) > k){
                hs.put(nums[i], hs.get(nums[i]) - 1);
                if(hs.get(nums[i]) == 0) hs.remove(nums[i]);
                i++;
            }

            max = Math.max(max, j - i + 1);

            j++;
            
        }

        return max;
    }
}