public class Solution {
    public boolean isValid(String code) {
        if (code.length() == 0) return true;
        Stack<String> tags = new Stack<>();
        int start = 0, tagNameStart = 1, tagNameEnd = 2, tagContent = 3, inCdata = 4, outTag = 5, end = 6;
        int state = 0, tagStart = -1;
        String cdataStart = "<![CDATA[", cdataEnd = "]]>";
        int i = 0;

        while (i < code.length()) {
            if (state == outTag) return false;
            if (code.charAt(i) == '<') {
                if (state == inCdata) {
                    i++;
                } else if (state == tagNameStart || state == tagNameEnd) {
                    return false;
                } else {
                    if (i+9 < code.length() && code.substring(i, i+9).toUpperCase().equals(cdataStart)) {
                        if (state == start) {
                            return false;
                        }
                        i += 9;
                        state = inCdata;
                    } else if (i+1 < code.length() && code.charAt(i+1) == '/') {
                        if (state != tagContent) {
                            return false;
                        }
                        tagStart = i+2;
                        i += 2;
                        state = tagNameEnd;
                    } else {
                        tagStart = i+1;
                        state = tagNameStart;
                        i++;
                    }
                }
            } else if (code.charAt(i) == '>') {
                if (state == inCdata || state == tagContent) {
                    i++;
                } else if (state == tagNameStart) {
                    if (tagStart == i || tagStart+9 < i) {
                        return false;
                    }
                    String tag = code.substring(tagStart, i);
                    tags.push(tag);
                    state = tagContent;
                    i++;
                } else if (state == tagNameEnd) {
                    if (tagStart == i|| tagStart+9 < i) {
                        return false;
                    }
                    String tag = code.substring(tagStart, i);
                    if (tags.empty() || !tag.equals(tags.pop())) {
                        return false;
                    }
                    if (tags.empty())
                        state = outTag;
                    else state = tagContent;
                    i++;
                } else {
                    return false;
                }
            } else if (code.charAt(i) == ']') {
                if (i+3 < code.length() && code.substring(i, i+3).equals(cdataEnd) && state == inCdata) {
                    i += 3;
                    state = tagContent;
                } else {
                    i++;
                }
            } else {
                if ((state == tagNameStart || state == tagNameEnd) && !Character.isUpperCase(code.charAt(i))) {
                    return false;
                }
                if (state == start || state == outTag) {
                    return false;
                }
                i++;
            }
        }

        return state == outTag;
    }
}