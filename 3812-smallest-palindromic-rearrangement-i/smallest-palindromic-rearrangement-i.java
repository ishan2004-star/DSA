class Solution {
    public String smallestPalindrome(String s) {
        
        int[] freq = new int[26];

        int one = -1;

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++){

            if(freq[i] == 0) continue;

            if(freq[i] == 1){
                one = i;
                freq[i]--;
                continue;
            }

            if(freq[i]%2 == 0){
                for(int j = 0; j < freq[i]/2; j++){
                    sb.append((char)(i + 'a'));
                }
                freq[i] /= 2;
            }
            else{
                one = i;
                freq[i]--;

                for(int j = 0; j < freq[i]/2; j++){
                    sb.append((char)(i + 'a'));
                }

                freq[i] /= 2;
            } 
        }


        if(one != -1){
            sb.append((char)(one + 'a'));
        }

        for(int i = 25; i >= 0; i--){

            if(freq[i] == 0) continue;
 
            for(int j = 0; j < freq[i]; j++){
                sb.append((char)(i + 'a'));
            }
        }

        return sb.toString();
    }
}