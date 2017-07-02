public class StringIterator {

    private String str;
    private int index, num;
    private char curr;

    public StringIterator(String compressedString) {
        this.str = compressedString;
        this.index = 0;
        this.num = 0;
    }
    
    public char next() {
        if (!hasNext()) return ' ';
        if (num <= 0) {
            loadNext();
        }
        num--;
        return curr;
    }
    
    public boolean hasNext() {
        if (index == str.length() && num == 0) return false;
        return true;
    }

    private void loadNext() {
        if (index+1 < str.length()) {
            curr = str.charAt(index);
            int j = index+1;
            while (j < str.length() && Character.isDigit(str.charAt(j)))
                j++;

            num = Integer.valueOf(str.substring(index+1, j));
            index = j;
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */