class Solution {

    public int maxProfit(int[] prices) {
        int result = 0;
        int rMax = prices[prices.length-1];
        for(int idx = prices.length - 1; idx >= 0; idx--) {
            int currVal = prices[idx];
            int profit = rMax - currVal;
            result = Math.max(result, profit);
            rMax = Math.max(rMax, prices[idx]);
            //System.out.println("currIdx :: " + idx + " currVal : " + currVal + ", profit : " + profit + " result : " + result + " rMax updated : " + rMax);
        }
        return result;
    }
}
