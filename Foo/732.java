class MyCalendarThree {

    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        this.map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);

        int cur = 0, cnt = 0;

        for (int k : map.values()) {
            cur += k;
            cnt = Math.max(cur, cnt);
        }

        return cnt;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */