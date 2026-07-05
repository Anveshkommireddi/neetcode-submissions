class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int idx = 0; idx < nums.length; idx++) {
            int num = nums[idx];
            int remSum = target - num;
            if(numsMap.containsKey(remSum)) {
                return new int[] {numsMap.get(remSum), idx};
            }
            numsMap.put(num, idx);
        }
        return new int[] {};
    }
}
