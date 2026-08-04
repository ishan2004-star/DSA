class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            int j=nums[i+1]-(nums[i]+1);

            for(int p=1;p<=j;p++){
                list.add(nums[i]+p);
            }
        }

        return list;
    }
}