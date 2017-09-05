class Excel {

    private int[][] data;
    private Map<String, Map<String, Integer>> affectedList;
    private Map<String, Map<String, Integer>> associatedList;

    public Excel(int H, char W) {
        int[] size = rawToCell(H, W);
        this.data = new int[size[0]+1][size[1]+1];
        this.affectedList = new HashMap<>();
        this.associatedList = new HashMap<>();
    }
    
    public void set(int r, char c, int v) {
        // System.out.println("Before:" + Arrays.deepToString(data));
        disAssociate(r, c);
        int[] p = rawToCell(r, c);
        int currVal = data[p[0]][p[1]];
        int nextVal = v;
        set(p, currVal, nextVal);
        // System.out.println("After:" + Arrays.deepToString(data));
    }
    
    private void set(int[] cell, int oldVal, int newVal) {
        String ps = cellToString(cell);
        data[cell[0]][cell[1]] = newVal;
        
        if (!affectedList.containsKey(ps)) return;

        for (String adj : affectedList.get(ps).keySet()) {
            // for (String adj : aff.ketSet()) {
                int mul = affectedList.get(ps).get(adj);
                if (mul <= 0) continue;
                int[] target = stringToCell(adj);
                int currVal = data[target[0]][target[1]];
                int nextVal = currVal - mul * oldVal + mul * newVal;
                set(target, currVal, nextVal);
            // }
        }
    }
    
    public int get(int r, char c) {
        int[] p = rawToCell(r, c);
        return data[p[0]][p[1]];
    }
    
    public int sum(int r, char c, String[] strs) {
        int[] t = rawToCell(r, c);
        String ts = rawToString(r, c);
        int res = 0;

        disAssociate(r, c);

        for (String range : strs) {
            //System.out.println(range);
            if (range.contains(":")) {
                String[] parts = range.split(":");
                int[] start = stringToCell(parts[0]);
                int[] end = stringToCell(parts[1]);
                //System.out.println(parts[0] + " Start: " + Arrays.toString(start) + parts[1] + " end: " + Arrays.toString(end));
                for (int i = start[0]; i <= end[0]; i++) {
                    for (int j = start[1]; j <= end[1]; j++) {
                        res += data[i][j];

                        String curr = cellToString(new int[] { i, j });
                        //if (data[i][j] != 0)
                        //    System.out.println("Adding " + curr + ":" + data[i][j]);
                        if (!affectedList.containsKey(curr)) affectedList.put(curr, new HashMap<>());
                        affectedList.get(curr).put(ts, affectedList.get(curr).getOrDefault(ts, 0) + 1);
                        if (!associatedList.containsKey(ts)) associatedList.put(ts, new HashMap<>());
                        associatedList.get(ts).put(curr, associatedList.get(ts).getOrDefault(curr, 0) + 1);
                    }
                }
            } else {
                int[] v = stringToCell(range);
                res += data[v[0]][v[1]];

                String curr = cellToString(new int[] { v[0], v[1] });
                //if (data[v[0]][v[1]] != 0)
                //    System.out.println("Adding " + curr + ":" + data[v[0]][v[1]]);
                if (!affectedList.containsKey(curr)) affectedList.put(curr, new HashMap<>());
                affectedList.get(curr).put(ts, affectedList.get(curr).getOrDefault(ts, 0) + 1);
                if (!associatedList.containsKey(ts)) associatedList.put(ts, new HashMap<>());
                associatedList.get(ts).put(curr, associatedList.get(ts).getOrDefault(curr, 0) + 1);
            }
        }

        data[t[0]][t[1]] = res;
        
        //System.out.println(res);
        //System.out.println(associatedList);
        //System.out.println(affectedList);
        
        // System.out.println("After sum: " + Arrays.deepToString(data));
        
        return res;
    }

    private void disAssociate(int r, char c) {
        String ts = rawToString(r, c);
        if (!associatedList.containsKey(ts)) return;
        for (String del : associatedList.get(ts).keySet()) {
            // for (String del : asso.keySet()) {
                int delVal = associatedList.get(ts).get(del);
                affectedList.get(del).put(ts, affectedList.get(del).get(ts) - delVal);
            // }
        }
        associatedList.remove(ts);
    }

    private String cellToString(int[] p) {
        return Character.toString((char)('A' + p[1])) + Integer.toString(p[0]+1);
    }

    private String rawToString(int r, char c) {
        return Character.toString(c) + Integer.toString(r);
    }

    private int[] stringToCell(String str) {
        return new int[] { Integer.valueOf(str.substring(1)) - 1, (str.charAt(0) - 'A') };
    }

    private int[] rawToCell(int r, char c) {
        return new int[] { r - 1, c - 'A' };
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */