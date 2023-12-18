package com.spa.tower;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TowerCity {

    public static class Tower {
        String name;
        int height;
        boolean relativeHeight;
        Tower relativeTo;

        public Tower(String name, int height, boolean relativeHeight) {
            this.name = name;
            this.height = height;
            this.relativeHeight = relativeHeight;
        }


        public Tower(String name, int height, boolean relativeHeight, Tower relativeTo) {
            this.name = name;
            this.height = height;
            this.relativeHeight = relativeHeight;
            this.relativeTo = relativeTo;
        }


        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }


        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Tower other = (Tower) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }


    }

    public Tower solve(Tower tower, Set<Tower> visited) throws CycleException {
        if (visited.contains(tower)) {
            throw new CycleException();
        }
        if (!tower.relativeHeight) {
            return tower;
        }
        visited.add(tower);
        tower.height = tower.height + this.solve(tower.relativeTo, visited).height;
        tower.relativeHeight = false;
        tower.relativeTo = null;
        return tower;
    }

    public Set<Tower> solve(List<Tower> towers) {
        Set<Tower> unsolvedTowers = new HashSet<>();
        for (var tower : towers) {
            try {
                this.solve(tower, new HashSet<>());
            } catch (CycleException e) {
                unsolvedTowers.add(tower);
            }
        }

        return unsolvedTowers;
    }
}
