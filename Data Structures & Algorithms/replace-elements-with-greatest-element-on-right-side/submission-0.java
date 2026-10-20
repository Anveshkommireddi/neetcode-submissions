class Solution {
    public int[] replaceElements(int[] arr) {
        int r_max = -1;
        for(int idx = arr.length - 1; idx >= 0; idx--) {
            int curr_num = arr[idx];
            arr[idx] = r_max;
            r_max = Math.max(curr_num, r_max);
        }
        return arr;
    }
}