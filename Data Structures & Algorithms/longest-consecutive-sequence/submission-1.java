class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int num : nums) {
            numsSet.add(num);
        }

        int result = 0;
        for(int num : nums) {
            if(numsSet.contains(num-1)) {
                continue;
            }
            int currNum = num;
            int length = 0;
            while(numsSet.contains(currNum)) {
                currNum++;
                length++;
            }
            result = Math.max(result, length);
        }
        return result; 
    }
}
