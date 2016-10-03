package cs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Leet401 {
    public List<String> readBinaryWatch(int num) {
        if (num > 8) return new ArrayList<String>();

        List<String> result = new ArrayList<String>();
        allComb(0, "", num, result);
        
        return result.stream().map(ss -> convertToTime(ss)).filter(ss -> ss != null).collect(Collectors.toList());
    }

    public void allComb(int index, String buffer, int leftOne, List<String> result) {
        if (index == 10) {
            result.add(buffer);
            return;
        }

        if (leftOne > 0) {
            allComb(index + 1, buffer + "1", leftOne - 1, result);
            if (10 - index > leftOne) {
                allComb(index + 1, buffer + "0", leftOne, result);
            }
        } else {
            allComb(index + 1, buffer + "0", leftOne, result);
        }
    }

    public String convertToTime(String s) {
        int hour = 0;
        for (int i = 0; i < 4; i++) {
            hour *= 2;
            hour += s.charAt(i) - '0';
        }

        if (hour > 11) return null;

        int min = 0;
        for (int i = 4; i < 10; i++) {
            min *= 2;
            min += s.charAt(i) - '0';
        }

        if (min > 59) return null;

        return String.format("%d:%02d", hour, min);
    }
}
