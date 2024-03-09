package com.spa.leetcode;



public class FlippingAnImage {

    //https://leetcode.com/problems/flipping-an-image/submissions/1191838006/
    public int[][] flipAndInvertImage(int[][] image) {
        for(var row : image){
            reverse(row);
        }

        for (int i = 0; i < image.length ; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return image;
    }

    private void reverse(int[] array){
        int front = 0;
        int back = array.length - 1;
        while (front < back){
            int tmp = array[front];
            array[front] = array[back];
            array[back] = tmp;
            front++;
            back--;
        }
    }


}
