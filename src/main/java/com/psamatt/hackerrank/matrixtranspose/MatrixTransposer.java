package com.psamatt.hackerrank.matrixtranspose;

public class MatrixTransposer {

    public int[][] transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (j > i) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
        return matrix;
    }
}
