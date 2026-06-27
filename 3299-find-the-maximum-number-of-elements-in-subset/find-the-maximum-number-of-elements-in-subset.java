class Solution {
    public int maximumLength(int[] nums) {
        
        HashMap<Long, Integer> hs = new HashMap<>();

        for(int num : nums){
            hs.put((long)num, hs.getOrDefault((long)num, 0) + 1);
        }

        int res = 0;

        if(hs.containsKey(1L)){
            res = hs.get(1L);

            if(res % 2 == 0) res--;
            hs.remove(1L);
        }

        for(long key : hs.keySet()){
            
            long num = key;
            int count = 0;

            while(hs.containsKey(num)){

                if(hs.get(num) >= 2){
                    count += 2;
                }
                else{
                    count++;
                    break;
                }
                num = num * num;
            }
            if(count % 2 == 0) count--;
            res = Math.max(res, count);
        }

        return res;
    }
}