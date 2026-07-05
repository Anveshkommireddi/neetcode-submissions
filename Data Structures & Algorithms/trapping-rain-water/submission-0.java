class Solution {
    
    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        Integer leftMax = Integer.MIN_VALUE;
        for(int idx = 0; idx < height.length; idx++) {
            lmax[idx] = Math.max(leftMax, height[idx]);
            leftMax = lmax[idx];
        }

        Integer rightMax = Integer.MIN_VALUE;
        for(int idx = height.length -1 ; idx >= 0; idx--) {
            rmax[idx] = Math.max(rightMax, height[idx]);
            rightMax = rmax[idx];
        }

        int result = 0;
        for(int idx = 0; idx < height.length; idx++) {
            int curr_height = height[idx];
            // System.out.println("Lmax for Idx is " + idx + ": " + lmax[idx]);
            // System.out.println("Rmax for Idx is " + idx + ": " + rmax[idx]);
            int water_stored = Math.min(lmax[idx], rmax[idx]);
            result = result + (water_stored-curr_height);
        }
        return result;
    }
}
