public class Solution {
    public String validIPAddress(String IP) {
        if (IP.endsWith(".") || IP.endsWith(":")) return "Neither";
        if (IP.contains(".")) {
            if (validateIPv4(IP)) return "IPv4";
        } else if (IP.contains(":")) {
            if (validateIPv6(IP)) return "IPv6";
        }

        return "Neither";
    }

    private boolean validateIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        for (String part : parts) {
            if (part.length() > 3 || part.length() == 0) return false;
            if (part.charAt(0) == '0' && part.length() != 1) return false;
            for (char c : part.toCharArray())
                if (!(c >= '0' && c <= '9')) return false;
            int val = Integer.valueOf(part);
            if (val > 255) return false;
        }
        return true;
    }

    private boolean validateIPv6(String ip) {
        String[] parts = ip.split(":");
        if (parts.length != 8) return false;
        for (String part : parts) {
            if (part.length() > 4 || part.length() == 0) return false;
            for (char c : part.toCharArray()) {
                if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F'))
                    return false;
            }
        }
        return true;
    }
}
