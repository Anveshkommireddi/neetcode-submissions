class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rp = new int[nums.length];
        int rpVal = 1;
        for(int idx = nums.length - 1; idx >= 0; idx--) {
            rp[idx] = rpVal;
            rpVal *= nums[idx];
        }
        int lpVal = 1;
        for(int idx = 0; idx < nums.length; idx++) {
            rp[idx] = rp[idx] * lpVal;
            lpVal = lpVal * nums[idx];
        }
        return rp;
    }
}  
