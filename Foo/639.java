public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        
        int mod = 1000000007;
        long[] dp = new long[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (i-1 >= 0) {
                    dp[i] += (dp[i-1] * 9 + mod) % mod;
                    if (s.charAt(i-1) == '1') {
                        if (i-2 >= 0) {
                            dp[i] += (dp[i-2] * 9 + mod) % mod;
                        } else {
                            dp[i] += 9;
                        }
                    } else if (s.charAt(i-1) == '2') {
                        if (i-2 >= 0) {
                            dp[i] += (dp[i-2] * 6 + mod) % mod;
                        } else {
                            dp[i] += 6;
                        }
                    } else if (s.charAt(i-1) == '*') {
                        if (i-2 >= 0) {
                            dp[i] += (dp[i-2] * 15 + mod) % mod;
                        } else {
                            dp[i] += 15;
                        }
                    }
                } else {
                    dp[i] += 9;
                }
            } else if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
                if (i-1 >= 0) {
                    dp[i] += (dp[i-1] + mod) % mod;
                    if (s.charAt(i-1) == '1' || s.charAt(i-1) == '*') {
                        if (i-2 >= 0) {
                            dp[i] += (dp[i-2] + mod) % mod;
                        } else {
                            dp[i] += 1;
                        }
                    }
                    
                    if ((s.charAt(i-1) == '2' || s.charAt(i-1) == '*') && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                        if (i-2 >= 0) {
                            dp[i] += (dp[i-2] + mod) % mod;
                        } else {
                            dp[i] += 1;
                        }
                    }
                } else {
                    dp[i] += 1;
                }
            } else if (s.charAt(i) == '0') {
                if (i-1 >= 0 && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' || s.charAt(i-1) == '*')) {
                    int mul = s.charAt(i-1) == '*' ? 2 : 1;
                    if (i-2 >= 0) {
                        dp[i] += (dp[i-2] * mul + mod) % mod;
                    } else {
                        dp[i] += mul;
                    }
                }
            }
        }

        return (int) dp[s.length()-1] % mod;
    }
}