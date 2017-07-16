public class LogSystem {

    private TreeMap<String, List<Integer>> bst;

    public LogSystem() {
        this.bst = new TreeMap<>((t1, t2) -> {
            String[] ts1 = t1.split(":");
            String[] ts2 = t2.split(":");
            int y1 = Integer.valueOf(ts1[0]);
            int y2 = Integer.valueOf(ts2[0]);
            if (y1 != y2) return y1 - y2;

            int m1 = Integer.valueOf(ts1[1]);
            int m2 = Integer.valueOf(ts2[1]);
            if (m1 != m2) return m1 - m2;

            int d1 = Integer.valueOf(ts1[2]);
            int d2 = Integer.valueOf(ts2[2]);
            if (d1 != d2) return d1 - d2;

            int h1 = Integer.valueOf(ts1[3]);
            int h2 = Integer.valueOf(ts2[3]);
            if (h1 != h2) return h1 - h2;

            int mm1 = Integer.valueOf(ts1[4]);
            int mm2 = Integer.valueOf(ts2[4]);
            if (mm1 != mm2) return mm1 - mm2;

            int s1 = Integer.valueOf(ts1[5]);
            int s2 = Integer.valueOf(ts2[5]);
            if (s1 != s2) return s1 - s2;

            return 0;
        });
    }
    
    public void put(int id, String timestamp) {
        if (!bst.containsKey(timestamp))
            bst.put(timestamp, new ArrayList<>());
        bst.get(timestamp).add(id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        String sn = normalizeStartTime(s, gra);
        String en = normalizeEndTime(e, gra);

        Map<String, List<Integer>> sub = bst.subMap(sn, true, en, true);
        for (List<Integer> l : sub.values()) res.addAll(l);

        return res;
    }

    private String normalizeStartTime(String t, String gra) {
        if (gra.equals("Second")) return t;

        String[] ts = t.split(":");

        if (gra.equals("Minute")) {
            return ts[0]+":"+ts[1]+":"+ts[2]+":"+ts[3]+":"+ts[4]+":00";
        } else if (gra.equals("Hour")) {
            return ts[0]+":"+ts[1]+":"+ts[2]+":"+ts[3]+":00:00";
        } else if (gra.equals("Day")) {
            return ts[0]+":"+ts[1]+":"+ts[2]+":00:00:00";
        } else if (gra.equals("Month")) {
            return ts[0]+":"+ts[1]+":01:00:00:00";
        } else {
            return ts[0]+":01:01:00:00:00";
        }
    }

    private String normalizeEndTime(String t, String gra) {
        if (gra.equals("Second")) return t;

        String[] ts = t.split(":");

        if (gra.equals("Minute")) {
            return ts[0]+":"+ts[1]+":"+ts[2]+":"+ts[3]+":"+ts[4]+":59";
        } else if (gra.equals("Hour")) {
            return ts[0]+":"+ts[1]+":"+ts[2]+":"+ts[3]+":59:59";
        } else if (gra.equals("Day")) {
            return ts[0]+":"+ts[1]+":"+ts[2]+":23:59:59";
        } else if (gra.equals("Month")) {
            return ts[0]+":"+ts[1]+":31:23:59:59";
        } else {
            return ts[0]+":12:31:23:59:59";
        }
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */