// reference: https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation/2
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int curr = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = pos[p2] + curr;

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : pos) {
            if (!(sb.length() == 0 && x == 0)) {
                sb.append(x);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}


public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num1.length(); i++) {
            int carry = 0;
            int carry2 = 0;
            int curr = num1.charAt(num1.length() - 1 - i) - '0';
            if (curr == 0) continue;

            List<Integer> tmp = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                if (k < res.size())
                    tmp.add(res.get(k));
                else
                    tmp.add(0);
            }

            for (int j = 0; j < num2.length(); j++) {
                int n2 = num2.charAt(num2.length() - 1 - j) - '0';
                int v = (n2 * curr + carry) % 10;
                carry = (n2 * curr + carry) / 10;

                if (tmp.size() < res.size()) {
                    int v2 = (v + res.get(tmp.size()) + carry2) % 10;
                    carry2 = (v + res.get(tmp.size()) + carry2) / 10;
                    tmp.add(v2);
                } else {
                    int v2 = (v + carry2) % 10;
                    carry2 = (v + carry2) / 10;
                    tmp.add(v2);
                }
            }

            if (carry + carry2 > 0) tmp.add(carry + carry2);
            res = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--)
            sb.append(res.get(i));

        return sb.toString();
    }
}



public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num1.length(); i++) {
            int carry = 0;
            int curr = num1.charAt(num1.length() - 1 - i) - '0';
            if (curr == 0) continue;

            List<Integer> tmp = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                tmp.add(0);
            }

            for (int j = 0; j < num2.length(); j++) {
                int n2 = num2.charAt(num2.length() - 1 - j) - '0';
                int v = (n2 * curr + carry) % 10;
                carry = (n2 * curr + carry) / 10;
                tmp.add(v);
            }

            if (carry > 0) tmp.add(carry);
            res = addTwo(res, tmp);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--)
            sb.append(res.get(i));

        return sb.toString();
    }

    private List<Integer> addTwo(List<Integer> l1, List<Integer> l2) {
        if (l1.isEmpty()) return l2;
        if (l2.isEmpty()) return l1;

        List<Integer> res = new ArrayList<>();
        int c = 0;
        int i = 0;
        while (i < l1.size() && i < l2.size()) {
            int v = (l1.get(i) + l2.get(i) + c) % 10;
            res.add(v);
            c = (l1.get(i) + l2.get(i) + c) / 10;
            i++;
        }

        while (i < l1.size()) {
            int v = (l1.get(i) + c) % 10;
            res.add(v);
            c = (l1.get(i) + c) / 10;
            i++;
        }
        while (i < l2.size()) {
            int v = (l2.get(i) + c) % 10;
            res.add(v);
            c = (l2.get(i) + c) / 10;
            i++;
        }

        if (c > 0) {
            res.add(c);
        }

        return res;
    }
}
