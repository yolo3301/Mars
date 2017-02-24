public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<>();

        Integer[] row = new Integer[rowIndex+1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int last = 1;
            for (int j = 1; j <= i / 2; j++) {
                if (i % 2 == 0 && j == i / 2) {
                    row[j] = last * 2;
                } else {
                    int tmp = last + row[j];
                    last = row[j].intValue();
                    row[j] = tmp;
                }
            }
        }

        int k = rowIndex;
        while (row[k] == null) {
            row[k] = row[rowIndex - k];
            k--;
        }

        return Arrays.asList(row);
    }
}