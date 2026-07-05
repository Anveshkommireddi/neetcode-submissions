class Solution {
    public int countSubstrings(String input) {
        		int result = 0;
		for (int idx = 0; idx < input.length(); idx++) {

			// even length
			int even = countPals(input, idx - 1, idx);
			result += even;

			// odd length
			int odd = countPals(input, idx, idx);
			result += odd;
		}
		return result;
    }

    private int countPals(String input, int left, int right) {
		int result = 0;
		while (left >= 0 && right < input.length()) {
			char leftChar = input.charAt(left);
			char rightChar = input.charAt(right);
			if (leftChar != rightChar) {
				return result;
			}
			result++;
			left--;
			right++;
		}
		return result;
	}
}
