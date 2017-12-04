class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 1) return words[0];
        
        Map<Character, Set<Character>> outbound = new HashMap<>();
        Map<Character, Set<Character>> inbound = new HashMap<>();
        Set<Character> distict = new HashSet<>();
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < Math.min(words[i-1].length(), words[i].length()); j++) {
                if (words[i-1].charAt(j) != words[i].charAt(j)) {
                    if (!outbound.containsKey(words[i-1].charAt(j)))
                        outbound.put(words[i-1].charAt(j), new HashSet<>());
                    outbound.get(words[i-1].charAt(j)).add(words[i].charAt(j));

                    if (!inbound.containsKey(words[i].charAt(j)))
                        inbound.put(words[i].charAt(j), new HashSet<>());
                    inbound.get(words[i].charAt(j)).add(words[i-1].charAt(j));
                    
                    break;
                }
            }

            if (i == 1) {
                for (char ch : words[i-1].toCharArray()) distict.add(ch);
            }
            for (char ch : words[i].toCharArray()) distict.add(ch);
        }
        
        //System.out.println(distict);

        Queue<Character> q = new LinkedList<>();

        for (char ch : distict) {
            if (!inbound.containsKey(ch))
                q.add(ch);
        }
        
        //System.out.println(q);

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            char cur = q.remove();
            sb.append(cur);
            if (!outbound.containsKey(cur)) continue;
            for (char n : outbound.get(cur)) {
                inbound.get(n).remove(cur);
                if (inbound.get(n).isEmpty())
                    q.add(n);
            }
        }
        
        //System.out.println(sb.toString());

        if (sb.length() < distict.size()) return "";

        return sb.toString();
    }
}