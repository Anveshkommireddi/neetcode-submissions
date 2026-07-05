class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sHash = generateHash(s);
        int[] tHash = generateHash(t);
        return isEqual(sHash, tHash);
    }

    private int[] generateHash(String input) {
        int[] hash = new int[26];
        char[] letters = input.toCharArray();
        for(char letter : letters) {
            int idx = letter - 'a';
            hash[idx]++;
        }
        return hash;
    }

    private boolean isEqual(int[] hash1, int[] hash2) {
        for(int idx = 0; idx < hash1.length; idx++) {
            if(hash1[idx] != hash2[idx])
                return false;
        }
        return true;
    }
}
