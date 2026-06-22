class Solution {
    int inf = Integer.MAX_VALUE / 2;

    HashMap<String, Integer> hs;

    public int minStickers(String[] stickers, String target) {

        int freq[] = new int[26];

        hs = new HashMap<>();

        for (int i = 0; i < target.length(); i++)
            freq[target.charAt(i) - 'a']++;

        int result = help(stickers, freq, 0, true, target.length());
        return result >= inf ? -1 : result;
    }

    public int help(String[] stickers, int freq[], int index, boolean flag, int len) {

        if (flag == false)
            return inf;

        if (len == 0)
            return 0;

        if (index == stickers.length)
            return inf;

        String ke = Arrays.toString(freq);
        String check = index + "#" + ke;

        if(hs.containsKey(check)) return hs.get(check);

        int[] store = new int[26];

        for (int i = 0; i < 26; i++) {
            store[i] = freq[i];
        }

        int[] f = new int[26];

        String s = stickers[index];

        for (int i = 0; i < s.length(); i++)
            f[s.charAt(i) - 'a']++;

        boolean flago = flag;
        flag = false;
        int original_len = len;

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0 && f[i] != 0) {
                int reduced = Math.min(freq[i], f[i]);
                freq[i] -= reduced;
                len -= reduced;
                flag = true;
            }
        }

        int take = 1 + help(stickers, freq, index, flag, len);

        for (int i = 0; i < 26; i++) {
            freq[i] = store[i];
        }

        len = original_len;

        int skip = help(stickers, freq, index + 1, flago, len);

        String key = Arrays.toString(freq);
        String k = index + "#" + key;

        hs.put(k, Math.min(take, skip));

        return Math.min(take, skip);
    }
}