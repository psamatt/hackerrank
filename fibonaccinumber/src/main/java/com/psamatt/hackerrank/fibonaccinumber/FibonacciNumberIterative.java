package com.psamatt.hackerrank.fibonaccinumber;

public class FibonacciNumberIterative {

    public int nthNumber(int n) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 0;
        for (int i = 2; i <= n; i++) {
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return n2;
    }
}
