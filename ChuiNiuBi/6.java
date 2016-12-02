/*
ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= numRows || numRows == 1)
            return s;
        
        char[] chs = new char[len];
        int step = 2 * (numRows - 1);
        int count = 0;
        
        for (int i = 0; i < numRows; i++) {
            int interval = step - 2 * i;
            for (int j = i; j < len; j += step) {
                chs[count++] = s.charAt(j);
                if (interval < step && interval > 0 && j + interval < len && count < len)
                    chs[count++] = s.charAt(j + interval);
            }
        }
        
        return new String(chs);
    }
}