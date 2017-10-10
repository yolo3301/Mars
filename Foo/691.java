class Solution {
    public int minStickers(String[] stickers, String target) {
        if (target.length() == 0) return 0;
        int[][] cnt = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char ch : stickers[i].toCharArray()) {
                cnt[i][ch-'a']++;
            }
        }

        char[] ts = target.toCharArray();
        Arrays.sort(ts);
        String str = new String(ts);

        return helper(str, cnt, new HashMap<>());
    }

    private int helper(String str, int[][] cnt, Map<String, Integer> memo) {
        if (str.length() == 0) return 0;
        if (memo.containsKey(str)) {
            return memo.get(str);
        }

        int[] local = new int[26];
        for (char ch : str.toCharArray()) {
            local[ch-'a']++;
        }

        int ret = Integer.MAX_VALUE;
        for (int[] sticker : cnt) {
            boolean useSticker = false;
            for (int i = 0; i < 26; i++) {
                if (sticker[i] > 0 && local[i] > 0) {
                    useSticker = true;
                    break;
                }
            }
            if (!useSticker) continue;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < Math.max(0, local[i]-sticker[i]); j++) {
                    sb.append((char)('a'+i));
                }
            }
            
            int tmp = helper(sb.toString(), cnt, memo);
            if (tmp != -1)
                ret = Math.min(ret, tmp+1);
        }

        memo.put(str, (ret == Integer.MAX_VALUE) ? -1 : ret);

        return memo.get(str);
    }
}
