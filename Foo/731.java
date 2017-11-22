class MyCalendarTwo {
    List<int[]> books;

    public MyCalendarTwo() {
        books = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        MyCalendar cal = new MyCalendar(); // use cal 1 every time
        for (int[] b : books) {
            // if there is overlap, add it
            // if already overlap, then double the overlap, which is triple
            if (start <= b[0] && end > b[0]) {
                if (!cal.book(b[0], Math.min(end, b[1])))
                    return false;
            } else if (start > b[0] && start < b[1]) {
                if (!cal.book(start, Math.min(end, b[1])))
                    return false;
            }
        }

        books.add(new int[]{start, end});
        return true;
    }

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
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */