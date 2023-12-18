package com.spa.codewars;

public class HowManyAreSmallerThanMeII {

    public record Level(int max, int min, int maxIndex, int minIndex) {

    }

    public static int[] smaller(int[] unsorted) {
        int lastIndex = unsorted.length - 1;
        Level[] minMaxs = new Level[unsorted.length];
        minMaxs[lastIndex] = new Level(unsorted[lastIndex], unsorted[lastIndex], lastIndex, lastIndex);
        for (int i = unsorted.length - 2; i >= 0; i--) {
            int newMax = Math.max(minMaxs[i + 1].max, unsorted[i]);
            int newMaxIndex = newMax == minMaxs[i + 1].max ? minMaxs[i + 1].maxIndex : i;
            int newMin = Math.min(minMaxs[i + 1].min, unsorted[i]);
            int newMinIndex = newMin == minMaxs[i + 1].min ? minMaxs[i + 1].minIndex : i;
            minMaxs[i] = new Level(newMax, newMin, newMaxIndex, newMinIndex);
        }
        int[] results = new int[unsorted.length];
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (unsorted[i] > minMaxs[i + 1].max) {
                results[i] = lastIndex - i;
            } else if (unsorted[i] <= minMaxs[i + 1].min) {
                results[i] = 0;
            } else {
                System.out.println("Here: " + unsorted[i]);
                for (int j = i; j < lastIndex; j++) {
                    if (unsorted[j] > minMaxs[j + 1].max) {
                        results[i] = lastIndex - j;
                        break;
                    } else if (unsorted[j] <= minMaxs[j + 1].min) {
                        results[i] = 0;
                        break;
                    }
                }
            }

        }
        return results;
    }
}
