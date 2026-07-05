class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       // int result = lcsHelper(text1, text1.length(), text2, text2.length());
        return lcs(text1, text2);
    }

    private int lcs(String s1, String s2) {
        int result = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int s1Len = 1; s1Len <= s1.length(); s1Len++) {
            for(int s2Len = 1; s2Len <= s2.length(); s2Len++) {
                if(s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
                    dp[s1Len][s2Len] = 1 + dp[s1Len - 1][s2Len - 1];
                } else {
                    dp[s1Len][s2Len] = Math.max(dp[s1Len][s2Len - 1], dp[s1Len - 1][s2Len]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private int lcsHelper(String s1, int s1Len, String s2, int s2Len) {
        if(s1Len <= 0 || s2Len <= 0) {
            return 0;
        }

        if(s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
            return 1 + lcsHelper(s1, s1Len - 1, s2, s2Len - 1);
        } else {
            return Math.max(lcsHelper(s1, s1Len - 1, s2, s2Len), lcsHelper(s1, s1Len, s2, s2Len - 1));
        }
    }
}
