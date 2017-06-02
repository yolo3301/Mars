public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> out = new HashMap<>();
        Map<Integer, Set<Integer>> in = new HashMap<>();
        
        for (List<Integer> list : seqs) {
            if (list.size() == 1) {
                if (list.get(0) <= 0 || list.get(0) > org.length)
                    return false;
                else {
                    if (!in.containsKey(list.get(0))) in.put(list.get(0), new HashSet<>());
                    if (!out.containsKey(list.get(0))) out.put(list.get(0), new HashSet<>());
                }
            }
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) <= 0 || list.get(i) > org.length) return false;
                if (list.get(i+1) <= 0 || list.get(i+1) > org.length) return false;
                
                if (!out.containsKey(list.get(i))) out.put(list.get(i), new HashSet<>());
                if (!out.containsKey(list.get(i+1))) out.put(list.get(i+1), new HashSet<>());
                if (!in.containsKey(list.get(i+1))) in.put(list.get(i+1), new HashSet<>());
                if (!in.containsKey(list.get(i))) in.put(list.get(i), new HashSet<>());
                out.get(list.get(i)).add(list.get(i+1));
                in.get(list.get(i+1)).add(list.get(i));
            }
        }

        if (in.isEmpty()) return false;

        Queue<Integer> queue = new LinkedList<>();
        for (int k : in.keySet()) {
            if (in.get(k).isEmpty()) queue.add(k);
        }

        int j = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            int curr = queue.remove();
            if (j >= org.length) return false;
            if (curr != org[j++]) return false;
            for (int next : out.get(curr)) {
                in.get(next).remove(curr);
                if (in.get(next).isEmpty()) queue.add(next);
            }
        }

        if (j < org.length) return false;

        return true;
    }
}