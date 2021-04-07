package com.psamatt.challenges.fibonaccinumber;

public class FibonacciNumberRecursive {
    private int n0 = 0;
    private int n1 = 1;
    private int n2 = 0;
    private int n = 0;

    public int nthNumberComplex(int n) {
        if (n < 2) {
            return n;
        }
        return nthNumberComplex(n - 1) + nthNumberComplex(n - 2);
    }

    public int nthNumberTailRecursive(int n, int a, int b) {
        if (n == 0) {
            return b;
        }
        return nthNumberTailRecursive(n - 1, a + b, a);
    }

    public int nthNumber(int n) {
        this.n = n;
        return recursive(1);
    }

    private int recursive(int count) {
        if (count < n) {
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
            recursive(count + 1);
        }
        return n2;
    }
}
