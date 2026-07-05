class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        boolean result = false;
        int[] s1hash = generateHash(s1);
        int[] s2hash = new int[26];
        for(int idx = 0; idx < s1.length(); idx++) {
            char currChar = s2.charAt(idx);
            s2hash[currChar - 'a']++;
        }
        for(int idx = s1.length(); idx < s2.length(); idx++) {
            boolean isPresent = compareHash(s1hash, s2hash);
            if(isPresent) return true;

            char oldChar = s2.charAt(idx - s1.length());
            s2hash[oldChar- 'a']--;

            char currChar = s2.charAt(idx);
            s2hash[currChar - 'a']++;
        }
        return compareHash(s1hash, s2hash);
    }

    private boolean compareHash(int[] s1Hash, int[] s2Hash) {
        for(int idx = 0; idx < s1Hash.length; idx++) {
            if(s1Hash[idx] != s2Hash[idx]) return false;
        }
        return true;
    }

    private int[] generateHash(String input) {
        int[] hash = new int[26];
        for(int idx = 0; idx < input.length(); idx++) {
            char currChar = input.charAt(idx);
            hash[currChar - 'a']++;
        }
        return hash;
    }
}
