class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for(int num : nums) {
            if(num == 1) {
                count++;
                result = Math.max(count, result);
            } else {
                count = 0;
            }
        }
        return result;
    }
}