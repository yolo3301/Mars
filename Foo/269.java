public class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        Map<Character, Set<Character>> out = new HashMap<>();
        Map<Character, Set<Character>> in = new HashMap<>();

        for (char c : words[0].toCharArray()) {
            if (!out.containsKey(c))
                out.put(c, new HashSet<>());
            if (!in.containsKey(c))
                in.put(c, new HashSet<>());
        }

        for (int i = 0; i < words.length-1; i++) {
            int j = 0;
            for (char c : words[i+1].toCharArray()) {
                if (!out.containsKey(c))
                    out.put(c, new HashSet<>());
                if (!in.containsKey(c))
                    in.put(c, new HashSet<>());
            }

            while (j < Math.min(words[i].length(), words[i+1].length())) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    out.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                    in.get(words[i+1].charAt(j)).add(words[i].charAt(j));
                    break;
                } else {
                    j++;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>(in.keySet());
        // System.out.println(set);
        for (char k : set) {
            if (in.get(k).isEmpty()) {
                queue.add(k);
                in.remove(k);
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char k = queue.remove();
            sb.append(k);
            for (char o : out.get(k)) {
                in.get(o).remove(k);
                if (in.get(o).isEmpty()) {
                    queue.add(o);
                    in.remove(o);
                }
            }
        }

        if (!in.isEmpty()) return "";

        return sb.toString();
    }
}