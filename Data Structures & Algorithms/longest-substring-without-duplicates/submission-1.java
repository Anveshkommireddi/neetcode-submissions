class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> charCountInfo = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char currChar = s.charAt(end);
            Integer prevIdx = charCountInfo.getOrDefault(currChar, -1);
           // System.out.println("start " + start + " , end " + end + " prevIdx " + prevIdx);
            if(prevIdx != -1 && prevIdx >= start ) {
                start = prevIdx + 1;
            }
            charCountInfo.put(currChar, end);
            int currLength = end - start + 1;
            result = Math.max(currLength, result);
            end++;
        }
        return result;
    }

    
}
