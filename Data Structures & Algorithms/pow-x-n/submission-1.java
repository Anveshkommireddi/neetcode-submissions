class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -1 * n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0)
            return 1;
        double half = fastPow(x * x, n / 2);
        return n % 2 == 0 ? half : x * half;
    }
}
