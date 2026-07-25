package com.spa.leetcode.medium;

import java.util.Random;

public class GenerateRandomPointsInCircle {

    private final Random random = new Random();
    private final double radius;
    private final double xCenter;
    private final double yCenter;

    public GenerateRandomPointsInCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        xCenter = x_center;
        yCenter = y_center;
    }

    public double[] randPoint() {
        return new double[]{random.nextDouble(xCenter - radius, xCenter + radius),
            random.nextDouble(yCenter - radius, yCenter + radius)};
    }

}
