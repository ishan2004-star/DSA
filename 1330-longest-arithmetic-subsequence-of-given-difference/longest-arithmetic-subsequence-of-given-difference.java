class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;

        map.put(arr[0], 1);

        for(int i = 1; i < arr.length; i++){

            int num = arr[i];

            if(map.containsKey(num - difference)){

                int prev = map.get(num - difference);
                
                map.put(num, prev + 1);

                max = Math.max(max, prev + 1);
            }
            else{
                map.put(num, 1);
            }
        }

        return max;
    }
}