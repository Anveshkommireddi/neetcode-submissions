class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> sortedCountInfo = new TreeMap<>();
        for(Integer number : hand) {
            int currCount = sortedCountInfo.getOrDefault(number, 0);
            sortedCountInfo.put(number, currCount + 1);
        }
        
        while(!checkIfAllZeros(sortedCountInfo)) {
            int currSize = groupSize;
            Integer firstNum = getNonZeroNumber(sortedCountInfo);
            currSize--;
            updateCount(firstNum, sortedCountInfo);
            Integer nextNum = firstNum + 1;
            while(currSize > 0 && sortedCountInfo.getOrDefault(nextNum, 0) > 0) {
                updateCount(nextNum, sortedCountInfo);
                nextNum = nextNum + 1;
                currSize--;
            }
            if(currSize > 0) return false;
        }
       
        return checkIfAllZeros(sortedCountInfo);
    }

    private boolean checkIfAllZeros(Map<Integer, Integer> sortedCountInfo) {
        for(Map.Entry<Integer, Integer> entry : sortedCountInfo.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    private Integer getNonZeroNumber(Map<Integer, Integer> sortedCountInfo) {
        for(Map.Entry<Integer, Integer> entry : sortedCountInfo.entrySet()) {
            if(entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private void updateCount(int num, Map<Integer, Integer> sortedCountInfo) {
            int currCount = sortedCountInfo.get(num);
            int newCount = currCount >= 1 ? currCount -1 : 0;
            sortedCountInfo.put(num, newCount);
    }
}
