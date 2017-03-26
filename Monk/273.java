public class Solution {
    Map<Integer, String> ten = new HashMap<>();
    Map<Integer, String> ty = new HashMap<>();

    public String numberToWords(int num) {
        fillTen();
        fillTy();

        if (num == 0) return "Zero";

        String res = "";
        for (int i = 0; i < 4 && num > 0; i++) {
            int curr = num % 1000;

            if (i == 0) {
                res = (curr == 0) ? "" : getHundres(curr);
            } else if (i == 1) {
                res = (curr == 0) ? res : getHundres(curr) + " Thousand " + res;
            } else if (i == 2) {
                res = (curr == 0) ? res : getHundres(curr) + " Million " + res;
            } else {
                res = (curr == 0) ? res : getHundres(curr) + " Billion " + res;
            }

            num /= 1000;
        }
        
        return res.trim();
    }

    private String getHundres(int num) {
        if (ten.containsKey(num)) return ten.get(num);

        String res = "";

        int h = num / 100;
        if (h != 0) {
            res = ten.get(h) + " Hundred";
        }

        int l = num % 100;
        if (ten.containsKey(l)) {
            res += " " + ten.get(l);
        } else {
            int l1 = l / 10;
            int l2 = l % 10;
            res += " " + ty.get(l1) + " " + ten.get(l2);
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