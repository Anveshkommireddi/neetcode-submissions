class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int idx = temperatures.length - 1; idx >= 0; idx--) {
            Integer currNum = temperatures[idx];
            if(stack.isEmpty()) {
                stack.push(idx);
            } else {
                while(!stack.isEmpty() && temperatures[stack.peek()] <= currNum) {
                    stack.pop();
                }
                result[idx] = stack.isEmpty() ? 0 : stack.peek() - idx;
                stack.push(idx);
            }
        }
        return result;
    }
}
