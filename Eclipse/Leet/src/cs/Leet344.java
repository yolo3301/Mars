package cs;

public class Leet344 {
	public String reverseString(String s) {
        if (s == null) return null;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length / 2; i++) {
            char tmp = chs[i];
            chs[i] = chs[chs.length - 1 - i];
            chs[chs.length - 1 - i] = tmp;
        }

        return new String(chs);
    }
}
