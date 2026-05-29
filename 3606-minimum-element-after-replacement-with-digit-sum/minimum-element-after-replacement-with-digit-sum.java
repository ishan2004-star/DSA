class Solution {
    public int minElement(int[] nums) {
        
        int max = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){

            String s = Integer.toString(nums[i]);

            int sum = 0;

            for(char c : s.toCharArray()){

                sum += c - '0';
            }

            max = Math.min(max, sum);

        }

        return max;
    }
}