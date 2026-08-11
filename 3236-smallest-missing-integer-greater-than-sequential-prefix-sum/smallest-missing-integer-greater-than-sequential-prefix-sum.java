class Solution {
    public int missingInteger(int[] nums) {

        if(nums.length == 1) return nums[0] + 1;
        
        int sum = nums[0];
        int i;

        for(i = 1; i < nums.length; i++){

            if(nums[i] == nums[i - 1] + 1){
                sum += nums[i];
            }
            else{
                break;
            }
        }

        HashSet<Integer> hs = new HashSet<>();
        int j = 0;

        while(j < nums.length){
            hs.add(nums[j++]);
        }

        for(int num : hs){
            if(hs.contains(sum)){
                sum++;
            }
            else{
                return sum;
            }
        }

        return sum;


    }
}