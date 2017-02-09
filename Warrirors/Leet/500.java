public class Solution {
    Set<Character> first = new HashSet<>();
    Set<Character> second = new HashSet<>();
    Set<Character> third = new HashSet<>();

    public String[] findWords(String[] words) {
        init();
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (fromOneRow(w)) res.add(w);
        }

        if (res.size() == 0) return new String[0];
        return res.toArray(new String[res.size()]);
    }

    private boolean fromOneRow(String word) {
        boolean a = false, b = false, c = false;
        for (char ch : word.toCharArray()) {
            if (first.contains(ch)) {
                if (b || c) return false;
                a = true;
            } else if (second.contains(ch)) {
                if (a || c) return false;
                b = true;
            } else {
                if (a || b) return false;
                c = true;
            }
        }

        return true;
    }

    private void init() {
        first.add('q');
        first.add('w');
        first.add('e');
        first.add('r');
        first.add('t');
        first.add('y');
        first.add('u');
        first.add('i');
        first.add('o');
        first.add('p');
        second.add('a');
        second.add('s');
        second.add('d');
        second.add('f');
        second.add('g');
        second.add('h');
        second.add('j');
        second.add('k');
        second.add('l');
        third.add('z');
        third.add('x');
        third.add('c');
        third.add('v');
        third.add('b');
        third.add('n');
        third.add('m');
        first.add('Q');
        first.add('W');
        first.add('E');
        first.add('R');
        first.add('T');
        first.add('Y');
        first.add('U');
        first.add('I');
        first.add('O');
        first.add('P');
        second.add('A');
        second.add('S');
        second.add('D');
        second.add('F');
        second.add('G');
        second.add('H');
        second.add('J');
        second.add('K');
        second.add('L');
        third.add('Z');
        third.add('X');
        third.add('C');
        third.add('V');
        third.add('B');
        third.add('N');
        third.add('M');
    }
}