class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<Integer> stack = new Stack<>();
        for (int idx = 0; idx < tokens.length; idx++) {
            String currWord = tokens[idx];
            if (operators.contains(currWord) && stack.size() >= 2) {
                Integer secondNum = stack.pop();
                Integer firstNum = stack.pop();
                if (currWord.equals("+")) {
                    stack.push(firstNum + secondNum);
                } else if (currWord.equals("-")) {
                    stack.push(firstNum - secondNum);
                } else if (currWord.equals("*")) {
                    stack.push(firstNum * secondNum);
                } else if (currWord.equals("/")) {
                    stack.push(firstNum/secondNum);
                }
            } else {
                int result = 0;
                int sign = 1;
                for (int wIdx = 0; wIdx < currWord.length(); wIdx++) {
                    char currChar = currWord.charAt(wIdx);
                    if (Character.isDigit(currChar)) {
                        result = result * 10 + (currChar - '0');
                    } else if(currChar == '-') {
                        sign = -1;
                    }
                }
                stack.push(sign * result);
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
