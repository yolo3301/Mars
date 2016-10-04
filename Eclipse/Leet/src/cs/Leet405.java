package cs;

import java.util.HashMap;
import java.util.Map;

public class Leet405 {
	public String toHex(int num) {
        if (num >= 0) return toHexPos(num);

        num = Math.abs(num);
        num ^= 0xffffffff;
        num++;
        return toHexPos(num);
    }

    private String toHexPos(int num) {
        if (num == 0) return "0";
        String result = "";
        Map<String, Character> map = new HashMap<>();
        map.put("0000", '0');
        map.put("0001", '1');
        map.put("0010", '2');
        map.put("0011", '3');
        map.put("0100", '4');
        map.put("0101", '5');
        map.put("0110", '6');
        map.put("0111", '7');
        map.put("1000", '8');
        map.put("1001", '9');
        map.put("1010", 'a');
        map.put("1011", 'b');
        map.put("1100", 'c');
        map.put("1101", 'd');
        map.put("1110", 'e');
        map.put("1111", 'f');

        String[] tmp = new String[8];
        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                sb.append(num & 1);
                num >>= 1;
            }
            tmp[i] = sb.reverse().toString();
        }

        boolean flag = true;
        for (int j = 7; j >= 0; j--) {
            if (map.get(tmp[j]) == '0' && flag) {
                continue;
            } else {
                if (map.get(tmp[j]) != '0') {
                    flag = false;
                }
                result += map.get(tmp[j]);
            }
        }

        return result;
    }
}
