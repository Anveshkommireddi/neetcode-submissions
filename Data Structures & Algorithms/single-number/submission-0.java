class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int idx = 1; idx < nums.length; idx++) {
            result = result ^ nums[idx];
        }
        return result;
    }
}
