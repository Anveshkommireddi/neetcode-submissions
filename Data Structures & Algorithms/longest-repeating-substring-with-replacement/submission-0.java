class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int start = 0;
        int end = 0;
        int result = 0;
        while(start <= end && end < s.length()) {
            char currChar = s.charAt(end);
            hash[currChar - 'A']++;
            while(!checkIfValid(hash, k)){
                  char startChar = s.charAt(start);
                  hash[startChar - 'A']--;
                  start++;
            }
            int currLength = end - start + 1;
            result = Math.max(result, currLength);
            end++;
        }
        return result;
    }

    private boolean checkIfValid(int[] hash, int k) {
        int maxIdx = getMaxUsedIdx(hash);
        int remCount = 0;
        for(int idx = 0; idx < hash.length; idx++) {
            if(idx != maxIdx) {
                remCount += hash[idx];
            }
        }
        return remCount <= k;
    }

    private int getMaxUsedIdx(int[] hash) {
        int resultIdx = 0;
        for(int idx = 1; idx < hash.length; idx++) {
            if(hash[idx] > hash[resultIdx]) {
                resultIdx = idx;
            }
        }
        return resultIdx;
    }
}
