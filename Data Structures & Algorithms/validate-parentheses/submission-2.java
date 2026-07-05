class Solution {
    public boolean isValid(String s) {
        boolean result = false;
        Stack<Character> stack = new Stack<>();
        for (int idx = 0; idx < s.length(); idx++) {
            char currChar = s.charAt(idx);
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                stack.push(currChar);
            } else if (!stack.isEmpty()
                && ((currChar == ')' && stack.peek() == '(')
                    || (currChar == '}' && stack.peek() == '{')
                    || (currChar == ']' && stack.peek() == '['))) {
                stack.pop();
            } else if (stack.isEmpty() && (currChar == ')' || currChar == ']' || currChar == '}')) {
                return false;
            } else {
                return false;
            }
        } 
        return stack.isEmpty();
    }
}
