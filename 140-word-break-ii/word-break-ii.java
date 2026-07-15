class Solution {
    List<String> ls;
    HashSet<String> hs;
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        hs = new HashSet<>();
        ls = new ArrayList<>();

        for(String st : wordDict){
            hs.add(st);
        }

        help(s, 0, "");

        return ls;
    }

    public void help(String s, int index, String res){

        if(index == s.length()){
            String r = res.substring(0, res.length() - 1);
            ls.add(r);
            return;
        }

        for(int i = index; i < s.length(); i++){

            String ans = s.substring(index, i + 1);

            if(hs.contains(ans)){
                help(s, i + 1, res + ans + " ");
            }

        }
    } 
}