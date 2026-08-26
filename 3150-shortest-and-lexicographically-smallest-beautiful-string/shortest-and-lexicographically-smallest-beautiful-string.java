class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int i = 0;
        int j = 0;
        int count = 0;
        String res = "";

        while(j < s.length()){

            if(s.charAt(j) == '1'){
                count++;
            }

            while(count == k){

                if(count == k){

                    if(j - i + 1 == res.length() && (s.substring(i, j + 1).compareTo(res) < 0)){
                        res = s.substring(i, j + 1);
                    }
                    if(res.length() == 0 || j - i + 1 < res.length()){
                        res = s.substring(i, j + 1);
                    }

                }

                if(s.charAt(i) == '1') count--;

                i++;
            }
            j++;

            
        }

        return res;
    } 
}