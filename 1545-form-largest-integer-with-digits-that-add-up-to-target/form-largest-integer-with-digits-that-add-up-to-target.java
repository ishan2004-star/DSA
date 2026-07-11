class Solution {
    HashMap<String, String> hs;
    public String largestNumber(int[] cost, int target) {

        hs = new HashMap<>();

        String res = help(cost, target, cost.length - 1);

        if(res == null) return "0";

        return res;
    }

    public String help(int[] costs, int target, int index){

        if(target == 0) return "";

        if(target < 0 || index < 0) return null;

        String key = target + "#" + index;

        if(hs.containsKey(key)) return hs.get(key);
        
        String pick = help(costs, target - costs[index], index);

        String skip = help(costs, target, index - 1);

        if(pick == null && skip != null){
            hs.put(key, skip); 
            return skip;
            }
        if(skip == null && pick != null) {
            hs.put(key, String.valueOf(index + 1) + pick);
            return String.valueOf(index + 1) + pick;
            }

        if(pick == null && skip == null) {
            hs.put(key, null);
            return null;
        }

        pick = String.valueOf(index + 1) + pick;

        if(pick.length() > skip.length()) {
            hs.put(key, pick);
            return pick;
        }
        if(skip.length() > pick.length()) {
            hs.put(key, skip);
            return skip;
        }


        String res = (pick).compareTo(skip) >= 0? pick:skip;

        hs.put(key, res);

        return res;

    }

}