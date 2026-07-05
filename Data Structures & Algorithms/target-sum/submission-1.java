class Solution {
    public int findTargetSumWays(int[] nums, int target) {
		Map<Pair, Integer> currIdxCurrSumMap = new HashMap<>();
		return sumsHelper(nums, 0, 0, target, currIdxCurrSumMap);
    }

 	private int sumsHelper(int[] nums, int currIdx, int currSum, int target,
			Map<Pair, Integer> currIdxCurrSumMap) {

		if (currIdx > nums.length)
			return 0;

		if (currIdx == nums.length) {
			if (currSum == target)
				return 1;
			return 0;
		}

		if (null != currIdxCurrSumMap.get(new Pair(currIdx, currSum))) {
			return currIdxCurrSumMap.get(new Pair(currIdx, currSum));
		}

		int currNum = nums[currIdx];
		// add
		int addCount = sumsHelper(nums, currIdx + 1, currSum + currNum, target, currIdxCurrSumMap);
		// sub
		int subCount = sumsHelper(nums, currIdx + 1, currSum + (currNum * -1), target, currIdxCurrSumMap);

		currIdxCurrSumMap.put(new Pair(currIdx, currSum), addCount + subCount);

		return currIdxCurrSumMap.get(new Pair(currIdx, currSum));
	}
}

class Pair {

	int currIdx;

	int currSum;

	public Pair(int currIdx, int currSum) {
		this.currIdx = currIdx;
		this.currSum = currSum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currIdx, currSum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return currIdx == other.currIdx && currSum == other.currSum;
	}

}
