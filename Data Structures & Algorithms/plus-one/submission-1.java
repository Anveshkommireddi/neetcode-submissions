class Solution {
    public int[] plusOne(int[] digits) {
        long num = 0l;
        for(int digit : digits) {
            num = num * 10 + digit;
        }
        long updated = num + 1;
        String updated_num = String.valueOf(updated);
        int[] result = new int[updated_num.length()];
        int idx = result.length - 1;
        Long currNum = updated;
        while(idx >= 0 && currNum >= 0) {
            long rem = currNum % 10;
            result[idx] = (int)rem;
            currNum = currNum / 10;
            idx--;
        }
        return result;
    }
}
