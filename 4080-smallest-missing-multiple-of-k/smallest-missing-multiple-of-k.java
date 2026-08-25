class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums) hs.add(num);

        int itr = 1;

        while(true){
            if(!hs.contains(k*itr)) return k*itr;
            itr++;
        }


    }
}