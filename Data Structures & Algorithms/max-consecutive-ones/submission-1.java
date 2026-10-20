class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int start = -1;
        for(int idx = 0; idx < nums.length; idx++) {
            int curr_num = nums[idx];
            if(curr_num == 1) {
                if(start == -1) {
                    start = idx;
                } 
                result = Math.max(result, idx - start + 1);
            } else {
                start = -1;
            }
        }
        return result;
    }
}