import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> hs = new HashMap<>();

        int min_index = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            hs.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (hs.containsKey(list2[i])) {
                if (i + hs.get(list2[i]) < min_index) {
                    min_index = i + hs.get(list2[i]);
                }
            }
        }

        for (int i = 0; i < list2.length; i++) {
            if (hs.containsKey(list2[i]) &&
                i + hs.get(list2[i]) == min_index) {
                result.add(list2[i]);
            }
        }

        return result.toArray(new String[0]);
    }
}