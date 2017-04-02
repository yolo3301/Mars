public class Solution {
    public int findRotateSteps(String ring, String key) {
        if (key.length() == 0) return 0;

        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char ch = ring.charAt(i);
            if (!index.containsKey(ch)) index.put(ch, new ArrayList<>());
            index.get(ch).add(i);
        }

        Map<Integer, Integer> minSteps = new HashMap<>();
        minSteps.put(0, 0);

        for (int i = 1; i <= key.length(); i++) {
            char ch = key.charAt(i-1);
            Map<Integer, Integer> next = new HashMap<>();

            for (int currIndex : index.get(ch)) {
                int minToCurr = Integer.MAX_VALUE;
                for (Map.Entry<Integer, Integer> prev : minSteps.entrySet()) {
                    int moves = Math.min(Math.abs(currIndex-prev.getKey()),
                                        ring.length()-Math.abs(currIndex-prev.getKey()));
                    minToCurr = Math.min(minToCurr, prev.getValue() + moves);
                }
                next.put(currIndex, minToCurr);
            }

            minSteps = next;
        }

        int res = Integer.MAX_VALUE;
        for (int v : minSteps.values()) res = Math.min(res, v);

        return res + key.length();
    }
}