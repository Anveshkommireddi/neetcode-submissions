class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String word : strs) {
            sb.append(word.length()).append("#").append(word);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        while(idx < str.length()) {
            int j = idx;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(idx, j));
            int start = j + 1;
            int end = start + length;
            result.add(str.substring(start, end));
            idx = end;
        }
        return result;
    }
}
