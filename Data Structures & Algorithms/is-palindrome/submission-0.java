class Solution {
    public boolean isPalindrome(String s) {
        String input = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if(!Character.isLetterOrDigit(input.charAt(start))) {
                start++;
            } else if(!Character.isLetterOrDigit(input.charAt(end))) {
                end--;
            } else if(input.charAt(start) != input.charAt(end)){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
