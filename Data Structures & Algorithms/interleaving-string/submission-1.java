class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
			return false;
		return interLeavingHelper(s1, 0, s2, 0, s3, 0);
    }

    private boolean interLeavingHelper(String s1, int s1Idx, String s2, int s2Idx, String s3, int s3Idx) {
		
		if (s1.length() == s1Idx && s2.length() == s2Idx && s3.length() == s3Idx) {
			return true;
		}
		if (s1Idx < s1.length() && s2Idx < s2.length() && s3Idx < s3.length() && s1.charAt(s1Idx) == s3.charAt(s3Idx)
				&& s2.charAt(s2Idx) == s3.charAt(s3Idx)) {
			return interLeavingHelper(s1, s1Idx + 1, s2, s2Idx, s3, s3Idx + 1)
					|| interLeavingHelper(s1, s1Idx, s2, s2Idx + 1, s3, s3Idx + 1);
		} else if (s1Idx < s1.length() && s3Idx < s3.length() && s1.charAt(s1Idx) == s3.charAt(s3Idx)) {
			return interLeavingHelper(s1, s1Idx + 1, s2, s2Idx, s3, s3Idx + 1);
		} else if (s2Idx < s2.length() && s3Idx < s3.length() && s2.charAt(s2Idx) == s3.charAt(s3Idx)) {
			return interLeavingHelper(s1, s1Idx, s2, s2Idx + 1, s3, s3Idx + 1);
		}
		return false;
	
	}
}
