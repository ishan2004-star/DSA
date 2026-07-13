class Solution {
    List<Integer> ls;
    public List<Integer> sequentialDigits(int low, int high) {
        ls = new ArrayList<>();
        help(low, high, "");
        Collections.sort(ls);
        return ls;
    }

    public void help(int low, int high, String s){
        if(!s.equals("") && Integer.parseInt(s) > high) return;

        if(!s.equals("") && Integer.parseInt(s) >= low) ls.add(Integer.parseInt(s));
 
        if(s.equals("")){
            for(int i = 1; i < 10; i++){
                help(low, high, s + i);
            }
        }
        else{
            char c = s.charAt(s.length() - 1);
            if(c == '9')return;
            int i = c - '0';
            int t = i + 1;
            help(low, high, s + t);
        }
    }
}