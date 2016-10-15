package cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet119 {
	public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<Integer>();

        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int last = 1;
            for (int j = 1; j <= i / 2; j++) {
                if (j == i / 2 && i % 2 == 0) {
                    row[j] = 2 * last;
                } else {
                    int tmp = last;
                    last = row[j].intValue();
                    row[j] = tmp + row[j];
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
