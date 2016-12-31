package cs;

import java.util.Arrays;

public class Leet274 {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        Arrays.sort(citations);
        System.out.println(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
        	System.out.println(i + " len:" + (citations.length - i) + " curr:" + citations[i] + " ");
            if (i > 0 && citations.length - i <= citations[i] && citations.length - i > citations[i-1])
                return citations.length - i;
            else if (i == 0 && citations[0] >= citations.length) {
                return citations.length;
            }
        }

        return 0;
    }
}
