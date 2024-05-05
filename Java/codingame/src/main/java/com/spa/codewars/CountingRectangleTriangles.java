package com.spa.codewars;
import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountingRectangleTriangles {

    // https://www.codewars.com/kata/57d99f6bbfcdc5b3b0000286/
    public static int countRectTriang(final Point[] points)
    {
        var uniquePoints = Arrays.stream(points).distinct().toList();
        Set<List<Point>> triangles = new HashSet<>();

        for (int i = 0; i < uniquePoints.size(); i++) {
            for (int j = i + 1; j < uniquePoints.size(); j++) {
                for (int k = j + 1; k < uniquePoints.size(); k++) {
                    triangles.add(List.of(uniquePoints.get(i), uniquePoints.get(j), uniquePoints.get(k)));
                }
            }
        }
        return (int) triangles.stream().filter(CountingRectangleTriangles::isRectangle).count();
    }

    private static boolean isRectangle(List<Point> triangle){
        int d1 = (int) triangle.get(0).distanceSq(triangle.get(1));
        int d2 = (int) triangle.get(0).distanceSq(triangle.get(2));
        int d3 = (int) triangle.get(1).distanceSq(triangle.get(2));

        int sum = d1 + d2 + d3;
        int max = Math.max(Math.max(d1, d2), d3);
        return max * 2 == sum;
    }
}
