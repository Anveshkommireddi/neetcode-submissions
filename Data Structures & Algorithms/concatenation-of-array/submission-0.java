class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[2 * nums.length];
        for(int idx = 0; idx < nums.length; idx++) {
            result[idx] = nums[idx];
            result[idx + nums.length] = nums[idx];
        }
        return result;
    }
}