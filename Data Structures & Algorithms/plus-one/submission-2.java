class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] temp = new int[digits.length];
        for (int idx = digits.length - 1; idx >= 0; idx--) {
            int sum = digits[idx] + carry;
            if (sum >= 10) {
                temp[idx] = sum % 10;
                carry = sum / 10;
            } else {
                temp[idx] = sum;
                carry = 0;
            }
        }

        if(carry != 0) {
            int[] result = new int[temp.length + 1];
            result[0] = carry;
            for(int tempIdx = 0; tempIdx < temp.length; tempIdx++) {
                result[tempIdx + 1] = temp[tempIdx];
            }
            return result;
        }
        return temp;
    }
}
