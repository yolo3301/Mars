public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int index = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                index = Math.min(index, j+map.get(list2[j]));
            }
        }

        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j]) && j+map.get(list2[j]) == index) {
                res.add(list2[j]);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}