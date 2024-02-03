package com.spa.leetcode;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

    private record Point(int x, int y) {
        Point move(char direction) {
            return switch (direction) {
                case 'N' -> new Point(this.x, this.y + 1);
                case 'S' -> new Point(this.x, this.y - 1);
                case 'E' -> new Point(this.x + 1, this.y);
                case 'W' -> new Point(this.x - 1, this.y);
                default -> this;
            };
        }
    }

    public boolean isPathCrossing(String path) {
        Set<Point> seen = new HashSet<>();
        Point current = new Point(0, 0);
        seen.add(current);
        for (int i = 0; i < path.length(); i++) {
            current = current.move(path.charAt(i));
            if (seen.contains(current)) {
                return true;
            } else {
                seen.add(current);
            }
        }
        return false;
    }

}
