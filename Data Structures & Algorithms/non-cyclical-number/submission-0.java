class Solution {
    public boolean isHappy(int n) {
        int fp = n;
        int sp = n;
        do {
            sp = digitalRoot(sp);
            fp = digitalRoot(digitalRoot(fp));
            if(sp == 1 || fp == 1) return true;
        } while(fp != sp);

        return false;
    }

    private int digitalRoot(int num) {
        int result = 0;
        while(num > 0) {
            int rem = num % 10;
            num = num / 10;
            result += rem * rem;
        }
        return result;
    }
}
