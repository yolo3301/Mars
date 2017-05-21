public class HitCounter {

    private static final int FIVE = 300;
    private TreeMap<Integer, Integer> map;
    private int cnt;

    /** Initialize your data structure here. */
    public HitCounter() {
        map = new TreeMap<>();
        cnt = 0;
        map.put(0, 0);
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp, ++cnt);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Map.Entry<Integer, Integer> prev = map.floorEntry(Math.max(0, timestamp-FIVE));
        if (prev == null) return 0;
        return cnt - prev.getValue();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */