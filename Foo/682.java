class Solution {
    public int calPoints(String[] ops) {
        List<Integer> rounds = new ArrayList<>();
        int sum = 0;

        for (String op : ops) {
            if (op.length() == 1 && !Character.isDigit(op.charAt(0))) {
                char o = op.charAt(0);
                switch (o) {
                    case '+':
                        int v1 = rounds.get(rounds.size()-1) + rounds.get(rounds.size()-2);
                        sum += v1;
                        rounds.add(v1);
                        break;
                    case 'D':
                        int v2 = 2 * rounds.get(rounds.size()-1);
                        sum += v2;
                        rounds.add(v2);
                        break;
                    case 'C':
                        sum -= rounds.get(rounds.size()-1);
                        rounds.remove(rounds.size()-1);
                        break;
                    default:
                        ;
                }
            } else {
                int v = Integer.parseInt(op);
                rounds.add(v);
                sum += v;
            }
        }

        return sum;
    }
}