public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] ap = a.split("\\+");
        String[] bp = b.split("\\+");
        int an = Integer.valueOf(ap[0]);
        int bn = Integer.valueOf(bp[0]);
        int ai = Integer.valueOf(ap[1].substring(0, ap[1].length()-1));
        int bi = Integer.valueOf(bp[1].substring(0, bp[1].length()-1));
        int fn = an*bn - ai*bi;
        int fi = an*bi + bn*ai;
        StringBuilder sb = new StringBuilder();
        sb.append(fn).append('+').append(fi).append('i');
        return sb.toString();
    }
}