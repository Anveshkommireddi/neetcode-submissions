class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int idx = 0; idx < nums.length; idx++) {
            result = result ^ nums[idx];
        }
        return result;
    }
}
