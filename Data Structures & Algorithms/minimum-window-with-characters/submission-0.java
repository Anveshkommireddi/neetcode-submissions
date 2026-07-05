class Solution {
    public String minWindow(String s, String t) {
        String result = "";
		Map<Character, Integer> hash = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			hash.put(t.charAt(i), hash.getOrDefault(t.charAt(i), 0) + 1);
		}

		int start = 0;
		int resLength = Integer.MAX_VALUE;
		Map<Character, Integer> window = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {
			window.put(s.charAt(end), window.getOrDefault(s.charAt(end), 0) + 1);
			while (start <= end && compareHash(hash, window)) {
				if (end - start + 1 < resLength) {
					resLength = end - start + 1;
					result = s.substring(start, end + 1);
				}
				window.put(s.charAt(start), window.getOrDefault(s.charAt(start), 0) - 1);
				start++;
			}
		}
		return result;
    }

    private boolean compareHash(Map<Character, Integer> hash, Map<Character, Integer> window) {
		for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
			int hashVal = entry.getValue();
			int windowVal = window.getOrDefault(entry.getKey(), 0);
			if (hashVal > windowVal)
				return false;
		}
		return true;
	}
}
