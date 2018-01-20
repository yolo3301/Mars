class Solution {
    public String crackSafe(int n, int k) {
        int total = (int)Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(0);
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        bt(sb, n, k, total, visited);
        return sb.toString();
    }

    private boolean bt(StringBuilder sb, int n, int k, int total, Set<String> visited) {
        if (visited.size() == total) return true;
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!visited.contains(next)) {
                sb.append(i);
                visited.add(next);
                if (bt(sb, n, k, total, visited))
                    return true;
                sb.delete(sb.length()-1, sb.length());
                visited.remove(next);
            }
        }
        return false;
    }
}