class Solution {
    public String nextClosestTime(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        Set<Integer> cand = new HashSet<>();
        cand.add(h % 10);
        cand.add(h / 10);
        cand.add(m % 10);
        cand.add(m / 10);

        if (cand.size() == 1) return time;

        List<Integer> list = new ArrayList<>(cand);
        Collections.sort(list);

        if (m % 10 < 9) {
            int r = nextGreater(list, m % 10);
            if (r != -1) {
                return new StringBuilder().append(t[0]).append(":").append(m/10).append(r).toString();
            }
        }

        if (m / 10 < 5) {
            int r = nextGreater(list, m / 10);
            if (r != -1 && r <= 5) {
                return new StringBuilder().append(t[0]).append(":").append(r).append(list.get(0)).toString();
            }
        }

        if (h < 23 && h % 10 < 9) {
            int r = nextGreater(list, h % 10);
            if (r != -1) {
                return new StringBuilder().append(h/10).append(r).append(":").append(list.get(0)).append(list.get(0)).toString();
            }
        }

        if (h % 10 == 9) {
            int r = nextGreater(list, h / 10);
            if (r != -1) {
                return new StringBuilder().append(r).append(list.get(0)).append(":").append(list.get(0)).append(list.get(0)).toString();
            }
        }

        return new StringBuilder().append(list.get(0)).append(list.get(0)).append(":").append(list.get(0)).append(list.get(0)).toString();
    }

    private int nextGreater(List<Integer> list, int curr) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > curr) return list.get(i);
        }

        return -1;
    }
}