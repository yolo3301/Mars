class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> lessRes = new ArrayList<>();
        List<Integer> greaterRes = new ArrayList<>();

        for (int i : arr) {
            if (i <= x) less.add(i);
            else greater.add(i);
        }

        Collections.reverse(less);
        
        int a = 0, b = 0;
        while (lessRes.size() + greaterRes.size() < k) {
            if (a >= less.size()) {
                greaterRes.add(greater.get(b++));
            } else if (b >= greater.size()) {
                lessRes.add(less.get(a++));
            } else {
                if (x - less.get(a) <= greater.get(b) - x)
                    lessRes.add(less.get(a++));
                else
                    greaterRes.add(greater.get(b++));
            }
        }

        Collections.reverse(lessRes);
        lessRes.addAll(greaterRes);

        return lessRes;
    }
}