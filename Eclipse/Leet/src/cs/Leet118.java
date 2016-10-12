package cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet118 {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;

        res.add(Arrays.asList(1));
        int i = 1;

        while (i < numRows) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(line);
            System.out.println(line);
            i++;
        }

        return res;
    }
}
