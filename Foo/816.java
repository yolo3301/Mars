class Solution {
    public List<String> ambiguousCoordinates(String S) {
        return addCommma(S.substring(1, S.length()-1));
    }

    private List<String> addDot(String s) {
        List<String> ret = new ArrayList<>();
        
        if (s.length() == 1) {
            ret.add(s);
            return ret;
        }

        boolean starts = (s.charAt(0) == '0');
        boolean ends = (s.charAt(s.length()-1) == '0');

        if (starts && ends) return ret;

        if (starts) {
            ret.add(s.substring(0, 1) + "." + s.substring(1));
            return ret;
        }

        if (ends) {
            ret.add(s);
            return ret;
        }

        for (int k = 0; k < s.length()-1; k++) {
            ret.add(s.substring(0, k+1) + "." + s.substring(k+1));
        }
        ret.add(s);

        return ret;
    }

    private List<String> addCommma(String s) {
        // System.out.println(s);
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < s.length()-1; i++) {
            List<String> l = addDot(s.substring(0, i+1));
            List<String> r = addDot(s.substring(i+1));
            for (String v1 : l) {
                for (String v2 : r) {
                    ret.add("(" + v1 + ", " + v2 + ")");
                }
            }
        }

        return ret;
    }
}