class Solution {

    List<Map<String, Integer>> scope = new ArrayList<>();

    public int evaluate(String exp) {
        scope.add(new HashMap<>());
        int ret = evalInternal(exp);
        scope.remove(scope.size()-1);
        return ret;
    }

    private int evalInternal(String exp) {
        if (exp.charAt(0) != '(') {
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
                return Integer.parseInt(exp);
            }

            // Search each scope back up
            for (int i = scope.size()-1; i >= 0; i--) {
                if (scope.get(i).containsKey(exp))
                    return scope.get(i).get(exp);
            }
        }

        List<String> tokens = tokenize(exp.substring(
            exp.charAt(1) == 'm' ? 6 : 5,
            exp.length()-1
        ));

        if (exp.startsWith("add", 1)) {
            return evaluate(tokens.get(0)) + evaluate(tokens.get(1));
        } else if (exp.startsWith("mult", 1)) {
            return evaluate(tokens.get(0)) * evaluate(tokens.get(1));
        } else {
            for (int j = 1; j < tokens.size(); j += 2) {
                scope.get(scope.size()-1).put(tokens.get(j-1), evaluate(tokens.get(j)));
            }
            return evaluate(tokens.get(tokens.size()-1));
        }
    }

    // Something good to remember.
    private List<String> tokenize(String exp) {
        List<String> ret = new ArrayList<>();
        int balance = 0;
        StringBuilder sb = new StringBuilder();

        for (String token : exp.split(" ")) {
            for (char c : token.toCharArray()) {
                if (c == '(') balance++;
                if (c == ')') balance--;
            }

            if (sb.length() > 0) sb.append(" ");
            sb.append(token);

            if (balance == 0) {
                ret.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        if (sb.length() > 0) {
            ret.add(sb.toString());
        }

        return ret;
    }
}