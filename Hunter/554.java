public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> sumCnt = new HashMap<>();
        int max = 0;
        for (int j = 0; j < wall.size(); j++) {
            List<Integer> list = wall.get(j);
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                sumCnt.put(sum, sumCnt.getOrDefault(sum, 0)+1);
                if (max == 0 || sumCnt.get(sum) > sumCnt.get(max))
                    max = sum;
            }
        }
        
        // System.out.println(sumCnt);

        return wall.size() - (max == 0 ? 0 : sumCnt.get(max));
    }
}