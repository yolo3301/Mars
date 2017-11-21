class MyCalendar {

    TreeMap<Integer, Integer> tree;

    public MyCalendar() {
        tree = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floor = tree.floorKey(start);
        if (floor != null && tree.get(floor) > start) return false;
        Integer ceiling = tree.ceilingKey(start);
        if (ceiling != null && ceiling < end) return false;

        tree.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */