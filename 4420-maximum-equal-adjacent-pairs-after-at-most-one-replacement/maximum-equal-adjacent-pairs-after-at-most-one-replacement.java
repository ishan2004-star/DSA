

class Solution {
    static class Info {
        int frequency = 0;
        int adjFreq = 0;
        HashMap<Integer, Integer> adjMap = new HashMap<>();
    }

    public int maxEqualAdjacentPairs(int[] nums) {
        HashMap<Integer, Info> map = new HashMap<>();
        int base = 0;

        for (int x : nums) {
            map.putIfAbsent(x, new Info());
            map.get(x).frequency++;
        }

        for (int i = 1; i < nums.length; i++) {
            int a = nums[i - 1];
            int b = nums[i];

            if (a == b) {
                base++;
                map.get(a).adjFreq++;
            } else {
                Info info = map.get(a);
                info.adjMap.put(b,
                    info.adjMap.getOrDefault(b, 0) + 1);
            }
        }

        int maxGain = 0;

        for (int x : map.keySet()) {
            for (int y : map.get(x).adjMap.keySet()) {
                int gain = map.get(x).adjMap.get(y)
                    + map.get(y).adjMap.getOrDefault(x, 0);

                maxGain = Math.max(maxGain, gain);
            }
        }

        return base + maxGain;
    }
}
