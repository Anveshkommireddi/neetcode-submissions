class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sumsHelper(nums, 0, 0, target);
    }

    private int sumsHelper(int[] nums, int currIdx, int currSum, int target) {
		
		if(currIdx > nums.length) return 0;
		
		if(currIdx == nums.length) {
			if(currSum == target) return 1;
			return 0;
		}
		
		int currNum = nums[currIdx];
		//add
		int addCount = sumsHelper(nums, currIdx + 1, currSum + currNum, target);
		//sub
		int subCount = sumsHelper(nums, currIdx + 1, currSum + (currNum * -1), target);
		
		return addCount + subCount;
	}
}
