class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] position_speed = new int[position.length][2];
        for (int positionIdx = 0; positionIdx < position.length; positionIdx++) {
            position_speed[positionIdx][0] = position[positionIdx];
            position_speed[positionIdx][1] = speed[positionIdx];
        }
        Arrays.sort(position_speed, (ps1, ps2) -> ps2[0] - ps1[0]);
        Stack<Double> stack = new Stack<>();
        for (int[] pos_speed : position_speed) {
            int curr_position = pos_speed[0];
            int curr_speed = pos_speed[1];
            double time_taken = (target - curr_position) / (curr_speed * 1.0);
            if (stack.isEmpty() || time_taken > stack.peek()) {
                stack.push(time_taken);
            } 
        }
        return stack.size();
    }
}
