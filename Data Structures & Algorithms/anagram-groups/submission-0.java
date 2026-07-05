class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsInfo = new HashMap<>();
        //generate common hash
        for(String word : strs) {
            String hash = generateHash(word);
            List<String> anagrams = anagramsInfo.getOrDefault(hash, new ArrayList<>());
            anagrams.add(word);
            anagramsInfo.put(hash, anagrams);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : anagramsInfo.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private String generateHash(String word) {
        int[] hash = new int[26];
        int wordLength = word.length();
        for(int idx = 0; idx < wordLength; idx++) {
            hash[word.charAt(idx) - 'a']++;
        }
        StringJoiner sb = new StringJoiner("#");
        for(int num: hash) {
            sb.add(String.valueOf(num));
        }
        return sb.toString();
    }
}
