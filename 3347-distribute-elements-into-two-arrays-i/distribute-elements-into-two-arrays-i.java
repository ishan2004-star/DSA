class Solution {
    public int[] resultArray(int[] nums) {

        List<Integer> ls1 = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>();


        ls1.add(nums[0]);
        ls2.add(nums[1]);


        for (int i = 2; i < nums.length; i++) {

            if (ls1.get(ls1.size() - 1) > ls2.get(ls2.size() - 1)) {
                ls1.add(nums[i]);
            } else {
                ls2.add(nums[i]);
            }
        }


        int index = 0;

        for (int num : ls1) {
            nums[index++] = num;
        }

        for (int num : ls2) {
            nums[index++] = num;
        }

        return nums;
    }
}