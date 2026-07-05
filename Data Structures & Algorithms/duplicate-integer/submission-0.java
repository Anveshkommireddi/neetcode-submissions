class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueVals = new HashSet<>();
        for(Integer num : nums) {
            if(!uniqueVals.add(num)) {
                return true;
            }
        }
        return false;
    }
}
