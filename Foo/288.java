public class ValidWordAbbr {

    private Map<String, Set<String>> abbr;

    public ValidWordAbbr(String[] dictionary) {
        this.abbr = new HashMap<>();
        for (String w : dictionary) {
            String b = getAbbr(w);
            if (!abbr.containsKey(b)) abbr.put(b, new HashSet<>());
            abbr.get(b).add(w);
        }
        // System.out.println(abbr);
    }
    
    public boolean isUnique(String word) {
        String b = getAbbr(word);
        return !abbr.containsKey(b) || (abbr.get(b).contains(word) && abbr.get(b).size() == 1);
    }

    private String getAbbr(String w) {
        if (w.length() <= 2) return w;
        else return new StringBuilder().append(w.charAt(0)).append(w.length()-2).append(w.charAt(w.length()-1)).toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */