class Solution {
    public int countCharacters(String[] words, String chars) {
        
        int freq[] = new int[26];

        int ans = 0;

        for(int i = 0; i < chars.length(); i++) freq[chars.charAt(i) - 'a']++;

        for(int i = 0; i < words.length; i++){
            String s = words[i];

            int f[] = new int[26];

            for(char c : s.toCharArray()){
                f[c - 'a']++;
            }

            boolean flag = true;

            for(char c : s.toCharArray()){
                if(freq[c - 'a'] < f[c - 'a']){
                    flag = false;
                    break;
                }
            }

            if(flag) ans += s.length();
        }

        return ans;
    }
}