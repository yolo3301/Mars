public class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q = new LinkedList<>();
        int[] people = new int[2];
        int[] ban = new int[2];

        for (char ch : senate.toCharArray()) {
            int x = (ch == 'R') ? 0 : 1;
            people[x]++;
            q.add(x);
        }

        while (people[0] > 0 && people[1] > 0) {
            int x = q.remove();
            people[x]--;
            if (ban[x] > 0) {
                ban[x]--;
            } else {
                ban[x^1]++;
                q.add(x);
                people[x]++;
            }
        }

        return (people[0] > 0) ? "Radiant" : "Dire";
    }
}