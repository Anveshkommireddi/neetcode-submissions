class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        int numIdx = 0;
        while(idx < nums.length) {
            if(nums[idx] != val) {
                swap(nums, idx, numIdx);
                numIdx++;
            } 
            idx++;
        }
        return numIdx;
    }

    private void swap(int[] nums, int fromIdx, int toIdx) {
        int temp = nums[fromIdx];
        nums[fromIdx] = nums[toIdx];
        nums[toIdx] = temp;
    }
    
}