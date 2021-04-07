package com.psamatt.challenges.fibonaccinumber;

public class FibonacciNumberChallenge {

    public static void main(String[] args) {
        int n = 10;
        FibonacciNumberIterative iterative = new FibonacciNumberIterative();
        System.out.println(iterative.nthNumber(n));

        FibonacciNumberRecursive recursive = new FibonacciNumberRecursive();
        System.out.println(recursive.nthNumberComplex(n));
        System.out.println(recursive.nthNumber(n));
    }
}
