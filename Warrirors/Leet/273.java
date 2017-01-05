public class Solution {
    Map<Integer, String> ten = new HashMap<>();
    Map<Integer, String> ty = new HashMap<>();
    public String numberToWords(int num) {
        fillTen();
        fillTy();

        if (num == 0) return "Zero";

        String res = "";
        for (int i = 0; i < 4 && num > 0; i++) {
            int c = num % 1000;
            if (i == 0) {
                res = (c == 0) ? "" : GetHundred(c);
            } else if (i == 1) {
                res = (c == 0) ? res : GetHundred(c) + " Thousand " + res;
            } else if (i == 2) {
                res = (c == 0) ? res : GetHundred(c) + " Million " + res;
            } else {
                res = (c == 0) ? res : GetHundred(c) + " Billion " + res;
            }
            num /= 1000;
        }

        return res.trim();
    }

    private String GetHundred(int num) {
        if (ten.containsKey(num)) return ten.get(num);
        String res = "";

        if (ten.containsKey(num % 100)) {
            res = ten.get(num % 100);
            num /= 100;
        } else {
            int c1 = num % 10;
            if (c1 != 0) {
                res = ten.get(c1);
            }
            num /= 10;
            if (num != 0) {
                int c2 = num % 10;
                res = ty.get(c2) + " " + res;
            }
            num /= 10;
        }

        if (num != 0) {
            int c3 = num % 10;
            res = ten.get(c3) + " Hundred " + res;
        }

        return res.trim();
    }

    private void fillTen() {
        ten.put(0, "");
        ten.put(1, "One");
        ten.put(2, "Two");
        ten.put(3, "Three");
        ten.put(4, "Four");
        ten.put(5, "Five");
        ten.put(6, "Six");
        ten.put(7, "Seven");
        ten.put(8, "Eight");
        ten.put(9, "Nine");
        ten.put(10, "Ten");
        ten.put(11, "Eleven");
        ten.put(12, "Twelve");
        ten.put(13, "Thirteen");
        ten.put(14, "Fourteen");
        ten.put(15, "Fifteen");
        ten.put(16, "Sixteen");
        ten.put(17, "Seventeen");
        ten.put(18, "Eighteen");
        ten.put(19, "Nineteen");
    }

    private void fillTy() {
        ty.put(2, "Twenty");
        ty.put(3, "Thirty");
        ty.put(4, "Forty");
        ty.put(5, "Fifty");
        ty.put(6, "Sixty");
        ty.put(7, "Seventy");
        ty.put(8, "Eighty");
        ty.put(9, "Ninety");
    }
}
