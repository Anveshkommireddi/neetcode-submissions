class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int idx = 0; idx < nums.length - 2; idx++) {
            int first_num = nums[idx];
            if (idx > 0 && nums[idx] == nums[idx - 1])
                continue;
            int target = -1 * first_num;
            twoSum(nums, first_num, idx + 1, nums.length - 1, target, result);
        }
        return result;
    }

    private void twoSum(
        int[] nums, int firstNum, int start, int end, int target, List<List<Integer>> result) {
        while (start < end) {
            int currSum = nums[start] + nums[end];
            if (currSum == target) {
                List<Integer> currResult = new ArrayList<>();
                currResult.add(firstNum);
                currResult.add(nums[start]);
                currResult.add(nums[end]);
                result.add(currResult);
                while(start < end && nums[start] == nums[start+1]) start++;
                while(start < end && nums[end] == nums[end-1]) end--;
            }
            if (currSum <= target) {
                start++;
            } else {
                end--;
            }
        }
    }
}
