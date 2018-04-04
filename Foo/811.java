class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String d : cpdomains) {
            String[] p = d.split(" ");
            int c = Integer.valueOf(p[0]);
            int fromIndex = 0;
            
            do {
                String sub = p[1].substring(fromIndex);
                cnt.put(sub, cnt.getOrDefault(sub, 0) + c);
                int next = p[1].indexOf(".", fromIndex);
                if (next < 0) break;
                fromIndex = next + 1;
            } while (fromIndex < p[1].length());
        }

        List<String> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            ret.add(e.getValue().toString() + " " + e.getKey());
        }

        return ret;
    }
}