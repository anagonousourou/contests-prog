package com.spa.leetcode;

//https://leetcode.com/problems/image-smoother/
public class ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = average(img, i, j);
            }
        }
        return result;
    }

    int average(int[][] img, int l, int col) {
        double sum = 0.0;
        int count = 0;
        for (int i = l - 1; i <= l + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < img.length && j >= 0 && j < img[0].length) {
                    sum += img[i][j];
                    count += 1;
                }
            }
        }
        return (int) Math.floor(sum / count);
    }
}
