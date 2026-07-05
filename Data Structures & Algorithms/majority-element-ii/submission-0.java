class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int num : nums) {
            if(cnt1 == 0 && num != e2) {
                e1 = num;
                cnt1++;
            } else if(cnt2 == 0 && num != e1) {
                e2 = num;
                cnt2++;
            } else if(num == e1) {
                cnt1++;
            } else if(num == e2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
       int minCount = nums.length/3;
       int res1 = 0;
       int res2 = 0;
       for(int num : nums) {
        if(num == e1) {
            res1++;
        } else if(num == e2) {
            res2++;
        }
       }
       List<Integer> result = new ArrayList<>();
       if(res1 > minCount) {
            result.add(e1);
       }

       if(res2 > minCount) {
            result.add(e2);
       }
       return result;
    }
}