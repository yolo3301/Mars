public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> children = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!children.containsKey(ppid.get(i))) children.put(ppid.get(i), new HashSet<>());
            children.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while (!q.isEmpty()) {
            int curr = q.remove();
            res.add(curr);
            if (!children.containsKey(curr)) continue;
            for (int n : children.get(curr)) {
                q.add(n);
            }
        }

        return res;
    }
}