class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==1) return strs[0];
       String small = "";
       String large = "";
       for(int idx = 0; idx < strs.length; idx++) {
         String curr = strs[idx];
         if(curr.length() > large.length()) {
            if(small.equals("")) {
                small = large;
            }
            large = curr;
         } else if(small.length() == 0 || curr.length() < small.length()) {
            small = curr;
         }
       }
       String prefix = findPrefix(small, large);
       for(String word : strs) {
            String newPrefix = findPrefix(prefix, word);
            if(newPrefix.equals("")) return newPrefix;
            prefix = newPrefix;
       }
       return prefix;
    }

    private String findPrefix(String small, String large) {
        StringBuilder sb = new StringBuilder();
        int sIdx = 0;
        int lIdx = 0;
        while(sIdx < small.length() && lIdx < large.length()) {
            if(small.charAt(sIdx) != large.charAt(lIdx)) {
               break;
            }
             sb.append(small.charAt(sIdx));
             sIdx++;
             lIdx++;
        }
        return sb.toString();
    }

}