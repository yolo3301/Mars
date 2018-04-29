class Solution {
    public int minimumLengthEncoding(String[] words) {
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        Arrays.sort(words);

        int cnt = 0;
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            if (i < words.length - 1) {
                if (!words[i+1].startsWith(words[i])) {
                    cnt++;
                    ret += words[i].length();
                }
            } else {
                cnt++;
                ret += words[i].length();
            }
        }

        return ret + cnt;
    }
}