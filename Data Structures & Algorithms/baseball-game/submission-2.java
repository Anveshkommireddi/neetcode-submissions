class Solution {
    
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op : operations) {
            if (op.equals("+")) {
                Integer prev_num_1 = stack.pop();
                Integer prev_num_2 = stack.pop();
                stack.push(prev_num_2);
                stack.push(prev_num_1);
                stack.push(prev_num_1 + prev_num_2);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                Integer val = Integer.parseInt(op);
                stack.push(val);
            }
        }
        int result = 0;
        while(!stack.isEmpty()) {
            Integer val = stack.pop();
            result += val;
        }
        return result;
    }
}