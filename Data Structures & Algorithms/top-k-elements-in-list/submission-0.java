class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for(int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0)+1);
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for(int idx = 0; idx < freq.length; idx++) {
            freq[idx] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            List<Integer> numsList = freq[count];
            numsList.add(num);
        }
        int[] result = new int[k];
        int resIdx = 0;
        for(int idx = freq.length - 1; idx >= 0 && resIdx < k; idx--) {
            for(Integer val : freq[idx] ) {
                result[resIdx++] = val;
                if(resIdx == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
