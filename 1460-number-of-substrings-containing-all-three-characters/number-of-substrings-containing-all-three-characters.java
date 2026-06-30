class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();

        HashMap<Character, Integer> hs = new HashMap<>();

        int left = 0;
        int right = 0;
        int count = 0;

        while(right < n){

            char c = s.charAt(right);
            
            if(!hs.containsKey(c)){
                hs.put(c, 1);
            }
            else{
                hs.put(c, hs.get(c) + 1);
            }

            while(hs.size() == 3){
                count += n - right;
                char ch = s.charAt(left++);
                hs.put(ch, hs.get(ch) - 1);
                if(hs.get(ch) == 0){
                    hs.remove(ch);
                }
            }
            right++;

        }

        return count;
        
    }
}