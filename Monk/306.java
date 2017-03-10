public class Solution {
    public boolean isAdditiveNumber(String num) {
        return bt(num, 0, new ArrayList<>());
    }

    private boolean bt(String num, int index, List<BigInteger> buffer) {
        if (index == num.length()) {
            return buffer.size() > 2;
        }

        boolean res = false;
        if (buffer.size() >= 2) {
            BigInteger curr = buffer.get(buffer.size() - 1).add(buffer.get(buffer.size() - 2));
            String currStr = curr.toString();
            if (index + currStr.length() > num.length()
                || !currStr.equals(num.substring(index, index + currStr.length()))) {
                return false;
            }

            buffer.add(curr);
            res = bt(num, index + currStr.length(), buffer);
            buffer.remove(buffer.size() - 1);
        } else {
            if (num.charAt(index) == '0') {
                buffer.add(BigInteger.ZERO);
                res = bt(num, index + 1, buffer);
                buffer.remove(buffer.size() - 1);
            } else {
                for (int i = index; i < num.length(); i++) {
                    buffer.add(new BigInteger(num.substring(index, i + 1)));
                    res |= bt(num, i + 1, buffer);
                    buffer.remove(buffer.size() - 1);
                    if (res) break;
                }
            }
        }

        return res;
    }
}