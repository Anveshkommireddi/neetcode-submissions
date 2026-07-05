class Solution {
    public String minWindow(String s, String t) {
         Map<Character, Integer> sourceCharCountInfo = new HashMap<>();
        for (int idx = 0; idx < t.length(); idx++) {
            char currChar = t.charAt(idx);
            sourceCharCountInfo.put(currChar, sourceCharCountInfo.getOrDefault(currChar, 0) + 1);
        }
        String result = "";
        int resultLength = Integer.MAX_VALUE;
        Map<Character, Integer> destCharCountInfo = new HashMap<>();
        int start = 0;
        int end = 0;
        while (start <= end && end < s.length()) {
            char currChar = s.charAt(end);
            destCharCountInfo.put(currChar, destCharCountInfo.getOrDefault(currChar, 0) + 1);
            while (isSubString(sourceCharCountInfo, destCharCountInfo)) {
                int currLength = end - start + 1;
                if(currLength < resultLength) {
                    result = s.substring(start, start + (end - start + 1));
                    resultLength = result.length();
                }
                char startChar = s.charAt(start);
                destCharCountInfo.put(startChar, destCharCountInfo.getOrDefault(startChar, 0) - 1);
                start++;
            }
            end++;
        }
        return result;
    }

    private boolean isSubString(Map<Character, Integer> source, Map<Character, Integer> dest) {
        boolean result = false;
        for(Map.Entry<Character, Integer> entry : source.entrySet()) {
            Character srcChar = entry.getKey();
            Integer srcValue = entry.getValue();

            Integer destValue = dest.getOrDefault(srcChar, 0);

            if(destValue < srcValue) {
                return false;
            }
        }
        return true;
    }
}
