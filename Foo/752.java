class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> ret = new ArrayList<>();
    
        String[] parts = ip.split("\\.");
        long ipNum = 0;
        for (int i = 0; i < 4; i++) {
            ipNum <<= 8;
            long cur = Long.valueOf(parts[i]);
            ipNum += cur;
        }

        while (n > 0) {
            int bits = Math.min(bitLen(ipNum & -ipNum), bitLen(n));
            int mask = 33 - bits;
            int cnt = (1 << (bits-1));

            ret.add(toIpStr(ipNum) + "/" + mask);
            n -= cnt;
            ipNum += cnt;
        }

        return ret;
    }

    private int bitLen(long n) {
        int ret = 0;
        while (n > 0) {
            n >>= 1;
            ret++;
        }
        return ret;
    }

    private int numOfTailingZero(int ip) {
        if (ip == 0) return 32;
        int ret = 0;
        while ((ip & 1) == 0) {
            ret++;
        }
        return ret;
    }

    private String toIpStr(long ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            long cur = (ip & 255);
            sb.insert(0, cur);
            if (i != 3) sb.insert(0, '.');
            ip >>= 8;
        }
        return sb.toString();
    }
}